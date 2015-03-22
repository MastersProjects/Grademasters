package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description Implementierte Methoden des Interfaces NoteDao
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin NoteJDBCDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class NoteJDBCDao extends Database implements NoteDao {

	private Connection con = null;
	
	/**
	 * @description Methode fuer eintragen einer neuen Note
	 * @param note, gewichtung, fach_ID, bennenung
	 * @throws SQLException
	 */
	public void addNote(int note, float gewichtung, int fach_ID, String benennung) throws SQLException {
		String sql = "INSERT INTO PRUEFUNG (Pruefung, Note, Gewichtung, Fach_ID) VALUES (?, ?, ?, ?)";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, benennung);
		ps.setLong(2, note);
		ps.setFloat(3, gewichtung);
		ps.setLong(4, fach_ID);
		
		ps.executeUpdate();
		closeCon();
	}

}
