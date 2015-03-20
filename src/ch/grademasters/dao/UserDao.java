package ch.grademasters.dao;

import java.sql.SQLException;
import java.util.List;

import ch.grademasters.model.User;

/**
 * @description Interface fuer die Tabelle User
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin UserDao.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */
public interface UserDao {

	/**
	 * @description Auslesen aller User
	 * @return Liste mit allen User
	 * @throws SQLException
	 */
	public abstract List<User> findAllUsers() throws SQLException;

	/**
	 * @description Eintragen eines neuen Users
	 * @param user
	 * @throws SQLException
	 */
	public abstract void insertUser(User user) throws SQLException;

}
