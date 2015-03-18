package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch.grademasters.model.User;

public class UserJDBCDao implements UserDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void insertUser(User user) throws SQLException {
		String sql = "INSERT INTO USER (Username, Passwort) VALUES (?, ?)";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, new String(user.getPasswort()));
		ps.executeUpdate();
		closeCon();
	}

	@Override
	public List<User> findAllUsers() throws SQLException {
		List<User> p = null;
		String sql = "SELECT Username, Passwort FROM USER";
		con = getCon();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		while (rs.next()) {
			p = new ArrayList<User>();
			User user = new User();
			user.setUsername(rs.getString("Username"));
			user.setPasswort(rs.getString("Passwort"));
			p.add(user);
		}
		closeCon();
		return p;

	}

	private void closeCon() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}

			if (con != null) {
				con.close();
			}
		}
		catch (SQLException e) {

		}
	}

	private Connection getCon() throws SQLException {
		if (this.con == null) {
			setCon(DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/GRADEMASTERS", "root", "1234"));
		}
		return con;
	}

	private void setCon(Connection con) {
		this.con = con;
	}

}
