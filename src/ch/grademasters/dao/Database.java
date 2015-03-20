package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @description Ober Klasse für alle Datenbank Klassen, enthaelt Infos zu
 *              Verbindung wie Verbindung schliessen.
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * @file Database.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class Database {
	private Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	/**
	 * Verbindungsinforamtionen fuer die DB
	 * @return Datenbank verbindung
	 * @throws SQLException
	 */
	protected Connection getCon() throws SQLException {
		setCon(DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/GRADEMASTERS", "root", "1234"));
		return con;
	}

	/**
	 * Setter fuer Connection
	 * @param con
	 */
	private void setCon(Connection con) {
		this.con = con;
	}

	/**
	 * Methode fuer schliessung der DB Verbindung
	 * @throws SQLException
	 */
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
