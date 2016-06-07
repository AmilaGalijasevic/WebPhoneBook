package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;

public class UserDaoImplementacija implements UserDaoInterface {

	Connection connection = ConnManager.getInstance().getConnection();

	@Override
	public User validateUser(String email, String password)  {
		User user = null;

		String query = "SELECT * FROM users WHERE email=? and password=?";
		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, email);
			statement.setString(2, password);

			rs = statement.executeQuery();

			if (rs.next()) {
				user = new User();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setCity(rs.getString("city"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public boolean register(User user) throws SQLException {

		String query = "INSERT INTO phonebook.users(name,lastname, email, password,city) VALUES(?,?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {

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
