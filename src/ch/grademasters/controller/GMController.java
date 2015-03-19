/**
 * 
 */
package ch.grademasters.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ch.grademasters.dao.UserDao;
import ch.grademasters.dao.UserJDBCDao;
import ch.grademasters.model.User;

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

	public void login(User user) {
		List<User> dbUsers = null;

		try {
			dbUsers = USER_DAO.findAllUsers();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String usernameLocal = user.getUsername();
		String passwortLocal = user.getPasswort();

		boolean login = false;

		for (User dbUser : dbUsers) {
			String usernameDb = dbUser.getUsername();
			String passwortDb = dbUser.getPasswort();

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
					System.out
							.println("Benutzername und/oder Passwort stimmen nicht!");
				}
				else if (StringUtils.isBlank(passwortLocal)) {
					System.out.println("Bitte Passwort eingeben");
					break;
				}
			}
			else if (StringUtils.isBlank(usernameLocal)) {
				System.out.println("Bitte Username eingeben");
				break;
			}

			if (!login) {
				System.out
						.println("Benutzername und/oder Passwort stimmen nicht!");
			}

		}

	}

}
