/**
 * 
 */
package ch.grademasters.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;

import ch.grademasters.dao.KlasseDao;
import ch.grademasters.dao.KlasseJDBCDao;
import ch.grademasters.dao.LehrerDao;
import ch.grademasters.dao.LehrerJDBCDao;
import ch.grademasters.dao.UserDao;
import ch.grademasters.dao.UserJDBCDao;
import ch.grademasters.exception.LoginError;
import ch.grademasters.exception.PasswortError;
import ch.grademasters.exception.SQLError;
import ch.grademasters.exception.UserError;
import ch.grademasters.exception.UserExist;
import ch.grademasters.model.Klasse;
import ch.grademasters.model.User;
import ch.grademasters.util.EncryptUtils;

/**
 * @author Luca Marti, ICT Berufsbildungscenter AG, luca.marti@bbcag.ch
 * @value GMController.java
 * @year 2015
 */
public class GMController {
	private static GMController instance = new GMController();
	private static final UserDao USER_DAO = new UserJDBCDao();
	private static final LehrerDao LEHRER_DAO = new LehrerJDBCDao();
	private static final KlasseDao KLASSE_DAO = new KlasseJDBCDao();
	
	public GMController() {
	}

	public static GMController getInstance() {
		return GMController.instance;
	}
	
	public void klasseSpeichern(Klasse klasse) {
		
		try {
			int Lehrer_ID = LEHRER_DAO.addLehrer(klasse);
			KLASSE_DAO.addKlasse(klasse, Lehrer_ID);
		}
		catch (SQLException e) {
			new SQLError();
		}
	}
	
	public Vector klassenAnzeigen () {
		try{
			return(KLASSE_DAO.getKlasse());
		}
		catch (SQLException e) {
			new SQLError();
		}
		return null;
	}

	public void insert(User currentUser) {

		String newUsername = currentUser.getUsername();

		boolean userAlreadyExists = false;

		// User ueberpruefung
		List<User> dbUsers = null;

		try {
			dbUsers = USER_DAO.findAllUsers();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		for (User dbUser : dbUsers) {
			String usernameDb = dbUser.getUsername();

			if (newUsername.equals(usernameDb)) {
				userAlreadyExists = true;
				new UserExist();
				break;
			}

		}

		if (!userAlreadyExists) {
			try {
				USER_DAO.insertUser(currentUser);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public boolean login(User currentUser) {
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

			passwortDb = EncryptUtils.base64decode(passwortDb);

			if (StringUtils.isNotBlank(usernameLocal)
					&& StringUtils.isNotBlank(usernameDb)
					&& usernameLocal.equals(usernameDb)) {

				if (StringUtils.isNotBlank(passwortLocal)
						&& StringUtils.isNotBlank(passwortDb)
						&& passwortLocal.equals(passwortDb)) {
					login = true;
					

				}
				else if (!passwortLocal.equals(passwortDb)) {
					if (i < 2) {
						LoginError loginError = new LoginError();
						loginError.setLocationRelativeTo(null);
						i = i + 1;
						login = false;
					}
				}
				else if (StringUtils.isBlank(passwortLocal)) {
					if (i < 2) {
						PasswortError passwortError = new PasswortError();
						passwortError.setLocationRelativeTo(null);
						i = i + 1;
						login = false;
					}
					break;
				}
			}
			else if (StringUtils.isBlank(usernameLocal)) {
				if (i < 2) {
					UserError userError = new UserError();
					userError.setLocationRelativeTo(null);
					i = i + 1;
					login = false;
				}
				break;
			}

			if (!login) {
				if (i < 2) {
					LoginError loginError = new LoginError();
					loginError.setLocationRelativeTo(null);
					i = i + 1;
					login = false;
				}
			}

		}
		return login;
	}
	
	


}
