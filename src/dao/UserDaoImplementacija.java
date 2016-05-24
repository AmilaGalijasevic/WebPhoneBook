package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dto.User;

public class UserDaoImplementacija implements UserDaoInterface{

	@Override
	public User validateUser(String email, String password) {
		User user = null;
		String query = "SELECT * FROM phonebook.users WHERE email=? && password=?";
		try (Connection connection = ConnManager.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, email);
			statement.setString(2, password);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					user = new User();
					user.setName(rs.getString("name"));
					user.setLastname(rs.getString("lastname"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setCity(rs.getString("city"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public boolean register(User user) {
		String query = "INSERT INTO phonebook.users(name,lastname, email, password,city) VALUES(?,?,?,?,?)";
		try (Connection connection = ConnManager.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, user.getName());
			statement.setString(2, user.getLastname());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getCity());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
		
	}


}
