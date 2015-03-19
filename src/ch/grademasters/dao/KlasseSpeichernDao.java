package ch.grademasters.dao;

import java.sql.SQLException;

import ch.grademasters.model.Klasse;

public interface KlasseSpeichernDao {
	
	public abstract void addKlasse(Klasse klasse) throws SQLException;

}
