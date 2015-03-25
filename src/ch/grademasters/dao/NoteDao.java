package ch.grademasters.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

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
	 * @description Auslesen aller Noten und Fach fuer das Diagramm
	 * @param fach_ID
	 * @return HasgMap mit allen Noten
	 * @throws SQLException
	 */
	public abstract ArrayList<Fach> getNotenUndFach() throws SQLException;
	
	/**
	 * @description Auslesen aller Noten 
	 * @param fach_ID
	 * @return Vector mit Note und 
	 * @throws SQLException
	 */
	public abstract Vector<?> getNotenByID(int fach_ID) throws SQLException;
	
}
