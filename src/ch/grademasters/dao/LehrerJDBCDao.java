package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ch.grademasters.model.Klasse;

public class LehrerJDBCDao extends Database implements LehrerDao {

	private Connection con = null;

	@Override
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
		while (rs.next()) {
			i = rs.getInt(1);
			break;
		}
		closeCon();
		return i;
	}

}
