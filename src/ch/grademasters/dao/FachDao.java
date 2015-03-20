package ch.grademasters.dao;

import java.sql.SQLException;

import ch.grademasters.model.Fach;


public interface FachDao {
	public abstract void addFach(int ID_Klasse, String fachName) throws SQLException;
}
