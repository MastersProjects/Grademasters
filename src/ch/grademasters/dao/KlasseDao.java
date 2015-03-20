package ch.grademasters.dao;

import java.sql.SQLException;
import ch.grademasters.model.Klasse;

public interface KlasseDao {
	
	public abstract void addKlasse(Klasse klasse, int Lehrer_ID) throws SQLException;
	
}
