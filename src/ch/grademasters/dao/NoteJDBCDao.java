package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class NoteJDBCDao extends Database implements NoteDao {

	private Connection con = null;
	
	@Override
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
