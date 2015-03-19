package ch.grademasters.dao;

import java.sql.SQLException;
import java.util.List;

import ch.grademasters.model.User;
import ch.grademasters.model.UserRegistration;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin UserDao.java
 *         Copyright Berufsbildungscenter GradeMasters 2015
 */

public interface UserDao {

	public abstract List<User> findAllUsers() throws SQLException;

	public abstract void insertUser(UserRegistration userRegistration)
			throws SQLException;

}
