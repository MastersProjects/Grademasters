package ch.grademasters.dao;

import java.sql.SQLException;

import ch.grademasters.model.Klasse;

public interface LehrerDao {
	
	public abstract int addLehrer(Klasse klasse) throws SQLException;
	
}
