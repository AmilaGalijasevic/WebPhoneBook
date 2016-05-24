package bo;

import java.sql.SQLException;

import dao.UserDaoImplementacija;
import dao.UserDaoInterface;
import dto.User;

public class UserImpl implements UserInterface {

	UserDaoInterface users = new UserDaoImplementacija();
	@Override
	public User validateUser(String email, String password) throws SQLException {
		User user = null;

		if (Helper.isValidPassword(password) && Helper.isValidEmail(email)) {
			user =users.validateUser(email, password);

			if (!user.getPassword().equals(password)) {
				user = null;
			}
		}

		return user;
	}


	@Override
	public boolean register(User user) throws SQLException {
		if (Helper.isValidUser(user)) {

			if (users.register(user)) {
				return true;
			}
		}

		return false;
	}

	}


