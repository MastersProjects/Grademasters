package ch.grademasters.dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;

import ch.grademasters.model.Fach;
import ch.grademasters.model.Klasse;
import ch.grademasters.model.KlassenLehrer;
import ch.grademasters.model.Pruefung;
import ch.grademasters.model.Zeugnis;

/**
 * @description Implementierte Methoden des Interfaces ZeugnisDao
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin
 *         ZeugnisJDBCDao.java Copyright Berufsbildungscenter GradeMasters 2015
 */
public class ZeugnisJDBCDao extends Database implements ZeugnisDao {
	// Connection auf null setzen
	private Connection con = null;

	/**
	 * @description Zerstellt das Zeugnis
	 * @param int klassen_ID
	 * @throws SQLException
	 * @return zeugnisse
	 */
	public ArrayList<Zeugnis> getZeugnis(int klassen_ID) throws SQLException {
		ArrayList<Zeugnis> zeugnisse = new ArrayList<Zeugnis>();

		// Query => List alle Faecher aus der Tabelle Fach, wo die Klassen_ID =
		// ? ist
		String sql = "Select * from FACH WHERE Klasse_ID = ?;";
		// Holt die Connection
		con = getCon();
		ps = con.prepareStatement(sql);
		// Klassen_ID erhalten
		ps.setInt(1, klassen_ID);
		// Query ausfuehren
		rs = ps.executeQuery();

		// Neues Zeugnis erstellen
		Zeugnis zeugnis = new Zeugnis();
		// Neue Klasse erstellen
		Klasse klasse;
		// Neuer Klassenlehrer erstellen
		KlassenLehrer klassenLehrer;
		// Query welcher die Klasse, Schule, Semerster und Klassenlehrer_ID von
		// der Klasse herauslist, wo die ID_Klasse = ? ist.
		String sql3 = "Select Klasse, Schule, Semester, Klassenlehrer_ID From Klasse WHERE ID_Klasse = ?;";
		//Holt die Conection
		con = getCon();
		ps3 = con.prepareStatement(sql3);
		//Bekommt die Klasse
		ps3.setInt(1, klassen_ID);
		//Query ausfuehren
		rs3 = ps3.executeQuery();
		//Solang es Werte hat, wiederhole das
		while (rs3.next()) {
			//Query welches den Name, Vorname und Email von der Tabelle Klassenlehrer list, wo die ID = ? ist
			String sql4 = "Select Name, Vorname, Email From KLASSENLEHRER WHERE ID_Klassenlehrer = ?;";
			con = getCon();
			ps4 = con.prepareStatement(sql4);
			//ERhaelt die Klassenlehrer_ID
			ps4.setInt(1, rs3.getInt("Klassenlehrer_ID"));
			//Query ausfuehren
			rs4 = ps4.executeQuery();
			//Solange es Werte hat, wiederhole das
			while (rs4.next()) {
				//Klassenlehrer erstellen und Werte hinzufuegen
				klassenLehrer = new KlassenLehrer(rs4.getString("Name"),
						rs4.getString("Vorname"), rs4.getString("Email"));
				//Klasse erstellen und Werte hinzufuegen
				klasse = new Klasse(klassenLehrer, rs3.getString("Klasse"),
						rs3.getString("Schule"), rs3.getInt("Semester"));
				//KlassenLehrer und klasse dem Zeugnis adden
				zeugnis.setKlassenLehrer(klassenLehrer);
				zeugnis.setKlasse(klasse);
				break;
			}
		}
		//Fach erstellen
		Fach fach;
		//Pruefung erstellen
		Pruefung pruefung;
		//Solange es Warte hat, wiederhole das
		while (rs.next()) {
			//Neues Fach erstellen
			fach = new Fach(rs.getString("Fach"));
			//Fach ID erhalten
			int fach_ID = rs.getInt("ID_Fach");
			//Fach dem Zeugnis adden
			zeugnis.addFach(fach);

			//Query welches alles aus der Tabelle Preufung liest, wo die ID = ?
			String sql2 = "Select * from PRUEFUNG WHERE FACH_ID = ?;";
			ps2 = con.prepareStatement(sql2);
			//Fach_ID erhalten
			ps2.setInt(1, fach_ID);
			//Query ausfuehren
			rs2 = ps2.executeQuery();

			//Wiederholen solange Werte hat
			while (rs2.next()) {
				//Neue Pruefung erstellen und Werte hinzufuegen
				pruefung = new Pruefung(null, rs2.getFloat("Note"),
						rs2.getFloat("Gewichtung"), null);
				//Preufung dem Fach hinzufuegen
				fach.addPruefung(pruefung);
			}
			//Zeugnis dem Zeugnisse adden
			zeugnisse.add(zeugnis);
		}
		//Connection closen
		closeCon();
		//Zeugnisse zurueck geben
		return zeugnisse;
	}

}
