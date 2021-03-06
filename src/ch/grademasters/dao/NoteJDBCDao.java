package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import ch.grademasters.model.Fach;
import ch.grademasters.model.Pruefung;

/**
 * @description Implementierte Methoden des Interfaces NoteDao
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin NoteJDBCDao.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */

public class NoteJDBCDao extends Database implements NoteDao {

	private Connection con = null;

	/**
	 * @description Methode fuer eintragen einer neuen Note
	 * @param note
	 *            , gewichtung, fach_ID, bennenung
	 * @throws SQLException
	 */
	public void addNote(float note, float gewichtung, int fach_ID,
			String benennung, String datum) throws SQLException {
		String sql = "INSERT INTO PRUEFUNG (Pruefung, Note, Gewichtung, Fach_ID, Datum) VALUES (?, ?, ?, ?, ?)";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, benennung);
		ps.setFloat(2, note);
		ps.setFloat(3, gewichtung);
		ps.setLong(4, fach_ID);
		ps.setString(5, datum);

		ps.executeUpdate();
		closeCon();
	}

	public ArrayList<Fach> getNotenUndFach() throws SQLException {
		ArrayList<Fach> noten = new ArrayList<Fach>();

		String sql = "Select * from Fach;";
		con = getCon();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		Fach fach;
		Pruefung pruefung;
		while (rs.next()) {
			fach = new Fach(rs.getString("Fach"));
			int fach_ID = rs.getInt("ID_Fach");

			String sql2 = "Select * from Pruefung WHERE FACH_ID = ?;";
			ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, fach_ID);
			rs2 = ps2.executeQuery();

			while (rs2.next()) {
				pruefung = new Pruefung(null, rs2.getFloat("Note"), rs2.getFloat("Gewichtung"), rs2.getString("Datum"));
				fach.addPruefung(pruefung);
			}
			noten.add(fach);
		}
		closeCon();
		return noten;
	}

	public Fach getNotenByID(int fach_ID) throws SQLException {	
		con = getCon();	
		
		String sql2 = "SELECT * FROM fach WHERE ID_Fach = ?";					
		ps2 = con.prepareStatement(sql2);		
		ps2.setInt(1, fach_ID);
		rs2 = ps2.executeQuery();
		
		Fach fach = null;

		while (rs2.next()) {
			fach = new Fach(rs2.getString("Fach"));  //Fehler
					
			String sql = "SELECT * FROM PRUEFUNG WHERE Fach_ID = ?";	
			ps = con.prepareStatement(sql);			
			ps.setInt(1, fach_ID);			
			rs = ps.executeQuery();
		
			while (rs.next()) {									
				Pruefung pruefung = new Pruefung(rs.getString("Pruefung"), rs.getFloat("Note"), rs.getFloat("Gewichtung"), rs.getString("Datum"));
				fach.addPruefung(pruefung);
				
			}
		}
		closeCon();
		
		return fach;


		
	}
	
	
}
