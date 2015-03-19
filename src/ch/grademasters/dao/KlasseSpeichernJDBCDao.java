package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;

import ch.grademasters.model.Klasse;

public class KlasseSpeichernJDBCDao extends Database implements
		KlasseSpeichernDao {
	private Connection con = null;

	@Override
	public void addKlasse(Klasse klasse) throws SQLException {
		String sql = "INSERT INTO KLASSE (Klasse, Schule, Semester) VALUES (?, ?, ?)";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, klasse.getKlassenname());
		ps.setString(2, klasse.getSchule());
		ps.setLong(3, klasse.getSemester());
		ps.executeUpdate();
		closeCon();
	}

}
