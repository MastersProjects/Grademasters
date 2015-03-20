package ch.grademasters.dao;

import java.sql.SQLException;
import java.util.Vector;

import ch.grademasters.model.Klasse;

public interface KlasseDao {
	
	public abstract void addKlasse(Klasse klasse, int Lehrer_ID) throws SQLException;
	public abstract Vector getKlasse() throws SQLException;
	
}
