package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ch.grademasters.model.Klasse;

/**
 * @description Implementierte Methoden des Interfaces LehrerDao
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * @file LehrerJDBCDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */
public class LehrerJDBCDao extends Database implements LehrerDao {
	//Variable fuer Verbindung
	private Connection con = null;

	/**
	 * @description Methode fuer eintragen eines Lehrer
	 * @param klasse
	 * @return int mit PriamryKey des Lehrer
	 * @throws SQLException
	 */
	public int addLehrer(Klasse klasse) throws SQLException {
		String sql = "INSERT INTO KLASSENLEHRER (Name, Vorname, Email) VALUES (?, ?, ?)";
		con = getCon();

		ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, klasse.getKlassenLehrer().getName());
		ps.setString(2, klasse.getKlassenLehrer().getVorname());
		ps.setString(3, klasse.getKlassenLehrer().getEmail());
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		int i = 0;
		
		//Gibt Primarykey zurueck
		while (rs.next()) {
			i = rs.getInt(1);
			break;
		}
		closeCon();
		return i;
	}

}
