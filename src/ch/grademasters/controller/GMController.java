/**
 * 
 */
package ch.grademasters.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Decoder;
import ch.grademasters.dao.UserDao;
import ch.grademasters.dao.UserJDBCDao;
import ch.grademasters.exception.LoginError;
import ch.grademasters.exception.PasswortError;
import ch.grademasters.exception.UserError;
import ch.grademasters.exception.UserExist;
import ch.grademasters.model.User;
import ch.grademasters.model.UserRegistration;

/**
 * @author Luca Marti, ICT Berufsbildungscenter AG, luca.marti@bbcag.ch
 * @value GMController.java
 * @year 2015
 */
public class GMController {
	private static GMController instance = new GMController();
	private static final UserDao USER_DAO = new UserJDBCDao();

	private static SecretKeySpec secretKeySpec = null;

	private GMController() {
	}

	public static GMController getInstance() {
		return GMController.getInstance(null);
	}

	public static GMController getInstance(SecretKeySpec secretKeySpec) {
		GMController.setSecretKeySpec(secretKeySpec);
		return GMController.instance;
	}

	public void insert(UserRegistration currentUser) {

		String newUsername = currentUser.getUsername();
		byte[] newPassword = currentUser.getPasswort();

		boolean userAlreadyExists = false;

		// User ueberpruefung
		List<User> dbUsers = null;

		try {
			dbUsers = USER_DAO.findAllUsers();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		int i = 1;

		for (User dbUser : dbUsers) {
			String usernameDb = dbUser.getUsername();

			
				if (newUsername.equals(usernameDb)) {
					userAlreadyExists = true;
					new UserExist();
					break;
				}
				

		}
		
		if(!userAlreadyExists) {
			try {
				USER_DAO.insertUser(currentUser);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void login(User currentUser) {
		List<User> dbUsers = null;

		try {
			dbUsers = USER_DAO.findAllUsers();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		String usernameLocal = currentUser.getUsername();
		String passwortLocal = currentUser.getPasswort();

		boolean login = false;
		int i = 1;

		for (User dbUser : dbUsers) {
			String usernameDb = dbUser.getUsername();
			String passwortDb = dbUser.getPasswort();

			BASE64Decoder myDecoder2 = new BASE64Decoder();
			byte[] crypted2;

			// Entschluesseln
			Cipher cipher2;
			byte[] cipherData2 = null;
			try {
				crypted2 = myDecoder2.decodeBuffer(passwortDb);
				cipher2 = Cipher.getInstance("AES");
				cipher2.init(Cipher.DECRYPT_MODE,
						GMController.getSecretKeySpec());
				cipherData2 = cipher2.doFinal(crypted2);
			}
			catch (NoSuchAlgorithmException | NoSuchPaddingException
					| IOException | InvalidKeyException
					| IllegalBlockSizeException | BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			passwortDb = new String(cipherData2);

			if (StringUtils.isNotBlank(usernameLocal)
					&& StringUtils.isNotBlank(usernameDb)
					&& usernameLocal.equals(usernameDb)) {

				if (StringUtils.isNotBlank(passwortLocal)
						&& StringUtils.isNotBlank(passwortDb)
						&& passwortLocal.equals(passwortDb)) {
					System.out.println("Herzlich Willkommen " + usernameLocal
							+ ", Du bist nun angemeldet!");
					login = true;

				}
				else if (!passwortLocal.equals(passwortDb)) {
					if (i < 2) {
						new LoginError();
						// System.out.println("Come on!");
						i = i + 1;
					}
				}
				else if (StringUtils.isBlank(passwortLocal)) {
					if (i < 2) {
						new PasswortError();
						i = i + 1;
					}
					break;
				}
			}
			else if (StringUtils.isBlank(usernameLocal)) {
				if (i < 2) {
					new UserError();
					i = i + 1;
				}
				break;
			}

			if (!login) {
				if (i < 2) {
					// System.out.println("Come on!!!!!!");
					new LoginError();
					i = i + 1;
				}
			}

		}

	}

	private static SecretKeySpec getSecretKeySpec() {
		return GMController.secretKeySpec;
	}

	private static void setSecretKeySpec(SecretKeySpec secretKeySpec) {
		GMController.secretKeySpec = secretKeySpec;
	}

}
