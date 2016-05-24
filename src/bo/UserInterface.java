package bo;

import java.sql.SQLException;

import dto.User;

public interface UserInterface {

	public User validateUser(String email, String password) throws SQLException;

	public boolean register(User user) throws SQLException;
}
