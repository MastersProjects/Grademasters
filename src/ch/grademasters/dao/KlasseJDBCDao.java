package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import ch.grademasters.model.Klasse;

/**
 * @description Implementierte Methoden des Interfaces KlasseDao
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin KlasseJDBCDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class KlasseJDBCDao extends Database implements KlasseDao {
	//Variable fuer Verbindung
	private Connection con = null;

	/**
	 * @description Eintragen einer neuen Klasse in die DB
	 * @param klasse, Lehrer_ID
	 */
	public void addKlasse(Klasse klasse, int Lehrer_ID) throws SQLException {
		String sql = "INSERT INTO KLASSE (Klasse, Schule, Semester, Klassenlehrer_ID) VALUES (?, ?, ?, ?)";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, klasse.getKlassenname());
		ps.setString(2, klasse.getSchule());
		ps.setLong(3, klasse.getSemester());
		ps.setLong(4, Lehrer_ID);
		ps.executeUpdate();
		closeCon();
	}

	/**
	 * @description Auslesen aller Klassen
	 * @return Map mit allen Klassen
	 */
	public Vector getKlasse() throws SQLException {
		String sql = "SELECT * FROM KLASSE";
		con = getCon();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		//Map fuer alle Klassen
		Vector klasseModel = new Vector();
		
		//While lauft ueber alle Datensaezte
		while (rs.next()) {
			int klasse_ID = 0;
			String klasse = null;
			
			//Fuegt alles zusammen
			klasse_ID = rs.getInt("ID_Klasse");
			klasse = rs.getString("Klasse");
			klasse = klasse + " Semester: " + rs.getString("semester");
			
			//Added alles an die Map
			klasseModel.addElement(new Item(klasse_ID, klasse));
		}
		return klasseModel;
	}

}
