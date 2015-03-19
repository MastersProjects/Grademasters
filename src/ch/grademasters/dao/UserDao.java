package ch.grademasters.dao;

import java.sql.SQLException;
import java.util.List;

import ch.grademasters.model.User;

/**
 * @description
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * UserDao.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public interface UserDao {
	public abstract void insertUser(User user) throws SQLException;

	public abstract List<User> findAllUsers() throws SQLException;

}
