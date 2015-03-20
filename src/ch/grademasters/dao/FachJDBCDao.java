package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;

import ch.grademasters.model.Fach;

public class FachJDBCDao extends Database implements FachDao {
	private Connection con = null;
	
	@Override
	public void addFach(Fach fach) throws SQLException {
		String sql ="INSERT INTO FACH (Fach, Klasse_ID) VALUES (?, ?)";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, fach.getFach());
		ps.setLong(2, 1);
		
		ps.executeUpdate(sql);
		closeCon();
	}

}
