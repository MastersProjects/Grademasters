/**
 * 
 */
package ch.grademasters.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ch.grademasters.abfrage.Abfrage_User;
import ch.grademasters.abfrage.Registr;
import ch.grademasters.dao.UserDao;
import ch.grademasters.dao.UserJDBCDao;
import ch.grademasters.exception.LoginError;
import ch.grademasters.exception.PasswortError;
import ch.grademasters.exception.UserError;
import ch.grademasters.exception.UserExist;
import ch.grademasters.model.Klasse;
import ch.grademasters.model.User;
import ch.grademasters.util.EncryptUtils;
import ch.grademasters.view.GradeMastersView;

/**
 * @author Luca Marti, ICT Berufsbildungscenter AG, luca.marti@bbcag.ch
 * @value GMController.java
 * @year 2015
 */
public class GMController {
	private static GMController instance = new GMController();
	private static final UserDao USER_DAO = new UserJDBCDao();

	private GMController() {
	}

	public static GMController getInstance() {
		return GMController.instance;
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

			passwortDb = EncryptUtils.base64decode(passwortDb);

			if (StringUtils.isNotBlank(usernameLocal)
					&& StringUtils.isNotBlank(usernameDb)
					&& usernameLocal.equals(usernameDb)) {

				if (StringUtils.isNotBlank(passwortLocal)
						&& StringUtils.isNotBlank(passwortDb)
						&& passwortLocal.equals(passwortDb)) {
					login = true;
					new GradeMastersView();

				}
				else if (!passwortLocal.equals(passwortDb)) {
					if (i < 2) {
						new LoginError();
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
					new LoginError();
					i = i + 1;
				}
			}

		}

	}
}
