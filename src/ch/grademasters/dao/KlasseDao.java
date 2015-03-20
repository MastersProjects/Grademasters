package ch.grademasters.dao;

import java.sql.SQLException;
import java.util.Vector;

import ch.grademasters.model.Klasse;

/**
 * @description Interface fuer die Tabelle Klasse
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin KlasseDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public interface KlasseDao {
	
	/**
	 * @description Eintragen einer Klasse in die DB
	 * @param klasse, Lehrer_ID
	 * @throws SQLException
	 */
	public abstract void addKlasse(Klasse klasse, int Lehrer_ID) throws SQLException;
	
	/**
	 * @description Auslesen der verschiedenen Klassen aus der DB
	 * @return Map mit allen Klassen
	 * @throws SQLException
	 */
	public abstract Vector<?> getKlasse() throws SQLException;
	
}
