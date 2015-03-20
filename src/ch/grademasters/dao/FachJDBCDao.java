package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;

import ch.grademasters.model.Fach;

public class FachJDBCDao extends Database implements FachDao {
	private Connection con = null;
	
	@Override
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
