package ch.grademasters.dao;

import java.sql.SQLException;

/**
 * @description Interface fuer die Tabelle Fach
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin FachDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public interface FachDao {
	
	/**
	 * @description Abstrakte Methode fuer eintragen der neuen Faecher
	 * @param ID_Klasse, fachName
	 * @throws SQLException
	 */
	public abstract void addFach(int ID_Klasse, String fachName) throws SQLException;
}
