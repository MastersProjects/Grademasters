package ch.grademasters.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.plaf.basic.*;

import java.util.Vector;

import ch.grademasters.controller.Item;
import ch.grademasters.model.Klasse;

public class KlasseJDBCDao extends Database implements KlasseDao {
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
		Vector model = new Vector();
		
		while(rs.next()) {
			int ID_Klasse = 0;
			String klasse = null;			
			ID_Klasse = rs.getInt("ID_Klasse");
			klasse = rs.getString("Fach");
			klasse = klasse + rs.getString("Semester");
						
			model.addElement(new Item(ID_Klasse, klasse));
		      
		} 
				
		return model;
	}
	
	

}
