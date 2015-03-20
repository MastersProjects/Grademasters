package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description Implementierte Methoden des Interfaces FachDao
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin FachJDBCDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class FachJDBCDao extends Database implements FachDao {
	//Variable fuer Verbindung
	private Connection con = null;
	
	/**
	 * @description Methode fuer eintragen eines neuen Faches
	 * @param ID_Klasse, fachName
	 * @throws SQLException
	 */
	public void addFach(int ID_Klasse, String fachName) throws SQLException {
		String sql ="INSERT INTO FACH (Fach, Klasse_ID) VALUES (?, ?)";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, fachName);
		ps.setLong(2, ID_Klasse);
		
		ps.executeUpdate();
		closeCon();
	}

}
