package ch.grademasters.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;

import ch.grademasters.dao.FachDao;
import ch.grademasters.dao.FachJDBCDao;
import ch.grademasters.dao.KlasseDao;
import ch.grademasters.dao.KlasseJDBCDao;
import ch.grademasters.dao.LehrerDao;
import ch.grademasters.dao.LehrerJDBCDao;
import ch.grademasters.dao.NoteDao;
import ch.grademasters.dao.NoteJDBCDao;
import ch.grademasters.dao.UserDao;
import ch.grademasters.dao.UserJDBCDao;
import ch.grademasters.dao.ZeugnisDao;
import ch.grademasters.dao.ZeugnisJDBCDao;
import ch.grademasters.exception.LoginError;
import ch.grademasters.exception.PasswortError;
import ch.grademasters.exception.SQLError;
import ch.grademasters.exception.UserError;
import ch.grademasters.exception.UserExist;
import ch.grademasters.messages.addInDb;
import ch.grademasters.model.Fach;
import ch.grademasters.model.Klasse;
import ch.grademasters.model.User;
import ch.grademasters.model.Zeugnis;
import ch.grademasters.util.EncryptUtils;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin GMController.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */

public class GMController {
	private static GMController instance = new GMController();
	private static final UserDao USER_DAO = new UserJDBCDao();
	private static final LehrerDao LEHRER_DAO = new LehrerJDBCDao();
	private static final KlasseDao KLASSE_DAO = new KlasseJDBCDao();
	private static final FachDao FACH_DAO = new FachJDBCDao();
	private static final NoteDao NOTE_DAO = new NoteJDBCDao();
	private static final ZeugnisDao ZEUGNIS_DAO = new ZeugnisJDBCDao();

	/**
	 * Konstruktor der Klasse GMCController nur Privat
	 */
	private GMController() {
	}

	public static GMController getInstance() {
		return GMController.instance;
	}

	/**
	 * Lehrer hizufuegen in die DB
	 * 
	 * @param klasse
	 */
	public void klasseSpeichern(Klasse klasse) {
		try {
			int Lehrer_ID = LEHRER_DAO.addLehrer(klasse);
			KLASSE_DAO.addKlasse(klasse, Lehrer_ID);
			new addInDb();
		}
		catch (SQLException e) {
			new SQLError();
		}
	}

	/**
	 * Alle Klassen auslesen aus der DB fuer GUI
	 * 
	 * @return alle Klassen in Vector
	 */
	public Vector<?> getKlasse() {
		Vector<?> klasse = null;
		try {
			klasse = KLASSE_DAO.getKlasse();
		}
		catch (SQLException e) {
			new SQLError();
		}
		return klasse;
	}

	/**
	 * Alle Faecher auslesen aus DB fuer GUI
	 * 
	 * @param klasse_ID
	 * @return Alle Faecher einer bestimmten Klasse in Vector
	 */
	public Vector<?> getFachByID(int klasse_ID) {
		Vector<?> fach = null;
		try {
			fach = FACH_DAO.getFachById(klasse_ID);
		}
		catch (SQLException e) {
			new SQLError();
		}
		return fach;
	}

	/**
	 * 
	 */
	public Fach getNotenByID(int fach_ID) {
		Fach fach = null;
		try {
			fach = NOTE_DAO.getNotenByID(fach_ID);
		}
		catch (SQLException e) {
			new SQLError();
		}
		return fach;
	}

	/**
	 * Ein neues Fach in die DB speichern
	 * 
	 * @param ID_Klasse
	 *            , fachName
	 */
	public void fachSpeichern(int ID_Klasse, String fachName) {
		try {
			FACH_DAO.addFach(ID_Klasse, fachName);
			new addInDb();
		}
		catch (SQLException e) {
			new SQLError();
		}
	}

	/**
	 * Eine neue Note in die Db eintragen
	 * 
	 * @param note
	 *            , gewichtung, fach_ID, benennung
	 */
	public void noteSpeichern(float note, float gewichtung, int fach_ID,
			String benennung, String datum) {
		try {
			NOTE_DAO.addNote(note, gewichtung, fach_ID, benennung, datum);
			new addInDb();
		}
		catch (SQLException e) {
			new SQLError();
		}
	}

	/**
	 * Liest alle Noten aus der DB und erstellt die dazugehoerigen Facher
	 * 
	 * @return Faecher Objekte mit allen Noten
	 */
	public ArrayList<Fach> getNotenUndFach() {
		try {
			return NOTE_DAO.getNotenUndFach();
		}
		catch (SQLException e) {
			new SQLError();
		}
		return null;
	}

	/**
	 * Holt alle Informationen aus DB um ein Zeugnis zuerstellen
	 * 
	 * @return
	 */
	public ArrayList<Zeugnis> getZeugnis(int klassen_ID) {
		try {
			return ZEUGNIS_DAO.getZeugnis(klassen_ID);
		}
		catch (SQLException e) {
			new SQLError();
		}
		return null;
	}

	/**
	 * Methode um neuen User in die DB einzutragen.
	 * 
	 * @param currentUser
	 */
	public static boolean userAlreadyExists;

	public void insert(User currentUser) {

		String newUsername = null;
		newUsername = currentUser.getUsername();

		// User ueberpruefung
		List<User> dbUsers = null;

		try {
			dbUsers = USER_DAO.findAllUsers();
		}
		catch (SQLException e) {
			new SQLError();
		}

		for (User dbUser : dbUsers) {
			String usernameDb = dbUser.getUsername();

			if (newUsername.equals(usernameDb)) {
				userAlreadyExists = true;
				break;
			} else {
				userAlreadyExists = false;
			}
		}
		if (userAlreadyExists == true) {
			new UserExist();
		}
		
		if (userAlreadyExists == false) {
			try {
				USER_DAO.insertUser(currentUser);
			}
			catch (SQLException e) {
				new SQLError();
			}
		}
	}

	/**
	 * Ueberprueft die eingaben des Users und preuft ob login korrekt
	 * 
	 * @param currentUser
	 * @return Boolean ob Login richtig oder falsch
	 */
	public boolean login(User currentUser) {
		List<User> dbUsers = null;

		try {
			dbUsers = USER_DAO.findAllUsers();
		}
		catch (SQLException e) {
			new SQLError();
		}

		String usernameLocal = currentUser.getUsername();
		String passwortLocal = currentUser.getPasswort();

		boolean login = false;
		boolean blank = false;
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
					login = false;
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
					blank = true;
				}
				break;
			}
		}
		if (login == false && blank == false) {
			LoginError loginError = new LoginError();
			loginError.setLocationRelativeTo(null);
		}
		return login;
	}

}
