package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch.grademasters.model.User;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin UserJDBCDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class UserJDBCDao extends Database implements UserDao {
	//Variable fuer Verbindung
	private Connection con = null;

	/**
	 * @description Eintragen eines neuen Users in DB
	 * @param user
	 * @throws SQLException
	 */
	public void insertUser(User user) throws SQLException {
		String sql = "INSERT INTO USER (Username, Passwort) VALUES (?, ?)";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPasswort());
		ps.executeUpdate();
		closeCon();
	}

	/**
	 * @description Auslesen aller User aus der DB
	 * @return Liste aller User
	 * @throws SQLException
	 */
	public List<User> findAllUsers() throws SQLException {

		String 
		sql = "SELECT * FROM USER";
		List<User> p = new ArrayList<User>();
		
		con = getCon();
		ps = con.prepareStatement(sql);
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
		closeCon();
		return p;

	}
}
