package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch.grademasters.model.User;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin UserJDBCDao.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */

public class UserJDBCDao extends Database implements UserDao {
	// Connection con auf null setzen
	private Connection con = null;

	/**
	 * User wird in DB eingefuegt
	 */
	@Override
	public void insertUser(User user) throws SQLException {
		// SQL Query
		String sql = "INSERT INTO USER (Username, Passwort) VALUES (?, ?)";
		// Connection
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPasswort());
		// Query ausfuehren
		ps.executeUpdate();
		// Connection schliessen (methode)
		closeCon();
	}

	/**
	 * Alle User aus der DB werden ausgelesen
	 */
	@Override
	public List<User> findAllUsers() throws SQLException {
		// SQL Query
		String sql = "SELECT * FROM USER";
		// User p ArrayList
		List<User> p = new ArrayList<User>();
		// Connection con
		con = getCon();
		ps = con.prepareStatement(sql);
		// Query ausfuehren
		rs = ps.executeQuery();

		// Macht es solange Datensaetze vorhande
		while (rs.next()) {
			// Neuer User anlegen
			User user = new User();
			// Usernamen setzen
			user.setUsername(rs.getString("Username"));
			// Passwort setzen
			user.setPasswort(rs.getString("Passwort"));
			// User zu ArrayList hinzufuegen
			p.add(user);
		}
		// Connection schliessen
		closeCon();
		// return p
		return p;

	}
}
