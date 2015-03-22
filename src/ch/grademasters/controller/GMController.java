/**
 * 
 */
package ch.grademasters.controller;

import java.sql.SQLException;
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
import ch.grademasters.exception.LoginError;
import ch.grademasters.exception.PasswortError;
import ch.grademasters.exception.UserError;
import ch.grademasters.exception.UserExist;
import ch.grademasters.model.Klasse;
import ch.grademasters.model.User;
import ch.grademasters.util.EncryptUtils;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * GMController.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class GMController {
	private static GMController instance = new GMController();
	private static final UserDao USER_DAO = new UserJDBCDao();
	private static final LehrerDao LEHRER_DAO = new LehrerJDBCDao();
	private static final KlasseDao KLASSE_DAO = new KlasseJDBCDao();
	private static final FachDao FACH_DAO = new FachJDBCDao();
	private static final NoteDao NOTE_DAO = new NoteJDBCDao();
	
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
	 * @param klasse
	 */
	public void klasseSpeichern(Klasse klasse) {
		try {
			int Lehrer_ID = LEHRER_DAO.addLehrer(klasse);
			KLASSE_DAO.addKlasse(klasse, Lehrer_ID);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Alle Klassen auslesen aus der DB fuer GUI
	 * @return alle Klassen in Vector
	 */
	public Vector<?> getKlasse() {
		Vector<?> klasse = null;
		try {
			klasse = KLASSE_DAO.getKlasse();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return klasse;
	}
	
	/**
	 * Alle Faecher auslesen aus DB fuer GUI
	 * @param klasse_ID
	 * @return Alle Faecher einer bestimmten Klasse in Vector
	 */
	public Vector<?> getFachByID(int klasse_ID) {
		Vector<?> fach = null;
		try {
			fach = FACH_DAO.getFachById(klasse_ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fach;	
	}
	
	/**
	 * Ein neues Fach in die DB speichern
	 * @param ID_Klasse, fachName
	 */
	public void fachSpeichern(int ID_Klasse, String fachName){
		try{
			FACH_DAO.addFach(ID_Klasse, fachName);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Eine neue Note in die Db eintragen
	 * @param note, gewichtung, fach_ID, benennung
	 */
	public void noteSpeichern(float note, float gewichtung, int fach_ID, String benennung) {
		try{
			NOTE_DAO.addNote(note, gewichtung, fach_ID, benennung);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Methode um neuen User in die DB einzutragen.
	 * @param currentUser
	 */
	public void insert(User currentUser) {

		String newUsername = null;
		newUsername = currentUser.getUsername();

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

	/**
	 * Ueberprueft die eingaben des Users und preuft ob login korrekt
	 * @param currentUser
	 * @return  Boolean ob Login richtig oder falsch
	 */
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
