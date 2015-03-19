package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	protected Connection getCon() throws SQLException {
		setCon(DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/GRADEMASTERS", "root", "1234"));
		return con;
	}

	private void setCon(Connection con) {
		this.con = con;
	}

	protected void closeCon() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
				con = null;
			}
		}
		catch (SQLException e) {

		}
	}

}
