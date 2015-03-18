/**
 * 
 */
package ch.grademasters.controller;

import java.sql.SQLException;
import java.util.List;

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
		String UserLocal = user.getUsername();
		String PasswortLocal = user.getPasswort();
		boolean login = false;

		for (User dbUser : dbUsers) {
			String UsernameDb = dbUser.getUsername();
			String PasswortDb = dbUser.getPasswort();

			if ((!UserLocal.equals("")) || (!PasswortLocal.equals(""))) { // Ueberprueft,
				// ob
				// die
				// TextFiels
				// nicht
				// leer
				// sind
				if ((UsernameDb.equals(UserLocal)) // Ueberprueft, ob die
						// Usernamen gleich sind
						// mit .equals()
						&& (PasswortDb.equals(PasswortLocal))) { // Ueberprueft,
					// ob
					// die
					// PWs
					// gleich
					// sind
					// mit
					// .equals()

					System.out.println("Herzlich Willkommen " + UserLocal
							+ ", Du bist nun angemeldet!"); // Gibt den
					// String aus
					login = true; // Setzt login auf true
				}
				else if (login = false) { // Wenn login false ist, dann gibt
					// es den String aus
					System.err.println("Fehler! Bitte Programm erneut starten");
				}
				else if (!(UsernameDb.equals(UserLocal))) { // Wenn die
					// Usernamen
					// nicht
					// uebereinstimmen,
					// dann gibt es
					// den String
					// aus
					System.err
							.println("Benutzername und/oder Passwort stimmen nicht!");
				}
				else if (!PasswortDb.equals(PasswortLocal)) { // Wenn die
					// PWs nicht
					// uebereinstimmen,
					// dann gitb
					// es den
					// String
					// aus
					System.err
							.println("Benutzername und/oder Passwort stimmen nicht!");
				}
			}
			else if ((UserLocal.equals("")) && (PasswortLocal.equals(""))) { // Ueberprueft,
				// ob
				// nichts
				// eingegeben
				// wurde
				System.err.println("Felder müssen ausgefüllt sein!");
			}

		}

	}

}
