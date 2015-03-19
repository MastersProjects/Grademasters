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
	private Connection con = null;

	@Override
	public void insertUser(User user) throws SQLException {
		String sql = "INSERT INTO USER (Username, Passwort) VALUES (?, ?)";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPasswort());
		ps.executeUpdate();
		closeCon();
	}

	@Override
	public List<User> findAllUsers() throws SQLException {
		String sql = "SELECT * FROM USER";
		List<User> p = new ArrayList<User>();
		con = getCon();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		while (rs.next()) {
			User user = new User();
			user.setUsername(rs.getString("Username"));
			user.setPasswort(rs.getString("Passwort"));
			p.add(user);
		}
		closeCon();
		return p;

	}
}

	