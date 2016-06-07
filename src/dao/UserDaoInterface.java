package dao;

import java.sql.SQLException;

import dto.User;

public interface UserDaoInterface {
	
	public User validateUser(String email, String password) ;

	public boolean register(User user) throws SQLException;
	
}
