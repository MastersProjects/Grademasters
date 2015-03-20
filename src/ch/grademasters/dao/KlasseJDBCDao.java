package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import ch.grademasters.model.Klasse;

public class KlasseJDBCDao extends Database implements
		KlasseDao {
	private Connection con = null;

	@Override
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

	@Override
	public Vector getKlasse() throws SQLException {
		String sql = "SELECT * FROM KLASSE";
		con = getCon();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		Vector klasseModel = new Vector();
		while(rs.next()) {
			int klasse_ID = 0;
			String klasse = null;
			
			klasse_ID = rs.getInt("ID_Klasse");
			klasse = rs.getString("Klasse");
			klasse = klasse + " Semester: " + rs.getString("semester");
			
			klasseModel.addElement(new Item(klasse_ID, klasse ));
		}
		return klasseModel;
	}
	
	

}
