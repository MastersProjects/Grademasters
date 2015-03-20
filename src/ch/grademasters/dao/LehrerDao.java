package ch.grademasters.dao;

import java.sql.SQLException;

import ch.grademasters.model.Klasse;

/**
 * @description Interface fuer die Tabelle Lehrer
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin LehrerDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public interface LehrerDao {
	
	/**
	 * @description Eintragen des Lehrers in DB
	 * @param klasse
	 * @return int mit PriamryKey des Lehrer
	 * @throws SQLException
	 */
	public abstract int addLehrer(Klasse klasse) throws SQLException;
	
}
