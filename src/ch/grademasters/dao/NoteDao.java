package ch.grademasters.dao;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import ch.grademasters.model.Fach;

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
	public abstract void addNote(float note, float gewichtung, int fach_ID, String benennung) throws SQLException;
	
	/**
	 * @description Auslesen aller Noten fuer das Diagramm
	 * @param fach_ID
	 * @return HasgMap mit allen Noten
	 * @throws SQLException
	 */
	public abstract ArrayList<Fach> getNoten() throws SQLException;
}
