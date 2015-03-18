package ch.grademasters.dao;

import java.sql.SQLException;
import java.util.List;

import ch.grademasters.model.User;

public interface UserDao {
	public abstract void insertUser(User user) throws SQLException;
	public abstract List<User> findAllUsers() throws SQLException;
	
	
}


	
