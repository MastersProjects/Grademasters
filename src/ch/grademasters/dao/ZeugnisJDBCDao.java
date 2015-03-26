package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch.grademasters.model.Fach;
import ch.grademasters.model.Klasse;
import ch.grademasters.model.KlassenLehrer;
import ch.grademasters.model.Pruefung;
import ch.grademasters.model.Zeugnis;

public class ZeugnisJDBCDao extends Database implements ZeugnisDao {
	private Connection con = null;

	public ArrayList<Zeugnis> getZeugnis(int klassen_ID) throws SQLException {
		ArrayList<Zeugnis> zeugnisse = new ArrayList<Zeugnis>();

		String sql = "Select * from FACH WHERE Klasse_ID = ?;";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setInt(1, klassen_ID);
		rs = ps.executeQuery();

		Zeugnis zeugnis = new Zeugnis();
		Klasse klasse;
		KlassenLehrer klassenLehrer;
		String sql3 = "Select Klasse, Schule, Semester, Klassenlehrer_ID From Klasse WHERE ID_Klasse = ?;";
		con = getCon();
		ps3 = con.prepareStatement(sql3);
		ps3.setInt(1, klassen_ID);
		rs3 = ps3.executeQuery();
		while (rs3.next()) {

			String sql4 = "Select Name, Vorname, Email From KLASSENLEHRER WHERE ID_Klassenlehrer = ?;";
			con = getCon();
			ps4 = con.prepareStatement(sql4);
			ps4.setInt(1, rs3.getInt("Klassenlehrer_ID"));
			rs4 = ps4.executeQuery();
			while (rs4.next()) {
				klassenLehrer = new KlassenLehrer(rs4.getString("Name"),
						rs4.getString("Vorname"), rs4.getString("Email"));
				klasse = new Klasse(klassenLehrer, rs3.getString("Klasse"),
						rs3.getString("Schule"), rs3.getInt("Semester"));
				zeugnis.setKlasse(klasse);
				break;
			}
		}

		Fach fach;
		Pruefung pruefung;
		while (rs.next()) {
			fach = new Fach(rs.getString("Fach"));
			int fach_ID = rs.getInt("ID_Fach");
			zeugnis.addFach(fach);

			String sql2 = "Select * from PRUEFUNG WHERE FACH_ID = ?;";
			ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, fach_ID);
			rs2 = ps2.executeQuery();

			while (rs2.next()) {
				pruefung = new Pruefung(null, rs2.getFloat("Note"),
						rs2.getFloat("Gewichtung"));
				fach.addPruefung(pruefung);
			}
			zeugnisse.add(zeugnis);
		}
		closeCon();
		return zeugnisse;
	}

}
