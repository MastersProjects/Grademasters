package ch.grademasters.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import ch.grademasters.model.Zeugnis;

/**
 * @description Interface fuer die Tabelle User
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin UserDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public interface ZeugnisDao {

	/**
	 * @description Auslesen aller Klassen
	 * @return Liste mit allen Klassen
	 * @throws SQLException
	 */
	public abstract ArrayList<Zeugnis> getZeugnis(int klassen_ID) throws SQLException; 

}
