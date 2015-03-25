package ch.grademasters.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
			String benennung) throws SQLException {
		String sql = "INSERT INTO PRUEFUNG (Pruefung, Note, Gewichtung, Fach_ID) VALUES (?, ?, ?, ?)";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, benennung);
		ps.setFloat(2, note);
		ps.setFloat(3, gewichtung);
		ps.setLong(4, fach_ID);

		ps.executeUpdate();
		closeCon();
	}

	public ArrayList getNoten() throws SQLException {
//		HashMap<int, Fach> noten = new HashMap<int, Fach>();
		
		ArrayList<Fach> noten = new ArrayList<Fach>();

		// String sql =
		// "Select Note, Fach from Pruefung Join Fach on Pruefung.Fach_ID=Fach.ID_Fach;";
		String sql = "Select * from Fach;";
		con = getCon();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		// String sql2 = "select count(Note) from pruefung group by Fach_ID;";

		ArrayList anzahlPruefungen = new ArrayList();

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
				pruefung = new Pruefung(null, rs2.getFloat("Note"),
						rs2.getFloat("Gewichtung"));
				fach.addPruefung(pruefung);
			}

			noten.add(fach);

		}
		return noten;
	}

}
