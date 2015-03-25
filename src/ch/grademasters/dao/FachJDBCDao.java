package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import ch.grademasters.item.Item;

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

	@Override
	public Vector<Item> getFachById(int klasse_ID) throws SQLException {
		String sql = "SELECT * FROM FACH WHERE Klasse_ID = ?";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setLong(1, klasse_ID);
		rs = ps.executeQuery();
		
		//Map fuer alle Klassen
		Vector<Item> fachModel = new Vector<Item>();
		
		//While lauft ueber alle Datensaezte
		while (rs.next()) {
			int fach_ID = 0;
			String fach = null;
					
			//Fuegt alles zusammen
			fach_ID = rs.getInt("ID_Fach");
			fach = rs.getString("Fach");
			
					
			//Added alles an die Map
			fachModel.addElement(new Item(fach_ID, fach));
		}
		closeCon();
		return fachModel;
	}

}
