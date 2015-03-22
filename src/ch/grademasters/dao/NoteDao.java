package ch.grademasters.dao;

import java.sql.SQLException;

/**
 * @description Interface fuer die Tabelle Note
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin KlasseDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public interface NoteDao {
	
	/**
	 * @description Eintragen einer neuen Note in DB 
	 * @param note, gewichtung, fach_ID, benennung
	 * @throws SQLException
	 */
	public abstract void addNote(int note, float gewichtung, int fach_ID, String benennung) throws SQLException;
}
