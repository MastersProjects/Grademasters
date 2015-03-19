/**
 * 
 */
package ch.grademasters.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ch.grademasters.dao.UserDao;
import ch.grademasters.dao.UserJDBCDao;
import ch.grademasters.exception.LoginError;
import ch.grademasters.exception.PasswortError;
import ch.grademasters.exception.UserError;
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
			e.printStackTrace();
		}

		String usernameLocal = user.getUsername();
		String passwortLocal = user.getPasswort();

		boolean login = false;
		int i = 1;

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
					if (i < 2) {
						new LoginError();
//						System.out.println("Come on!");
						i = i+1;
					}
				}
				else if (StringUtils.isBlank(passwortLocal)) {
					if (i < 2) {
						new PasswortError();
						i = i+1;
					}
					break;
				}
			}
			else if (StringUtils.isBlank(usernameLocal)) {
				if (i < 2) {
					new UserError();
					i = i+1;
				}
				break;
			}

			if (!login) {
				if (i < 2) {
//					System.out.println("Come on!!!!!!");
					new LoginError();
					i = i+1;
				}
			}

		}

	}

}
