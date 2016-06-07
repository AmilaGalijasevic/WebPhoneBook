package bo;

import dao.UserDaoImplementacija;
import dto.User;

public class Helper {

	public static boolean isUserNotNull(User user) {
		if (user == null) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean isUserAlreadyRegistered(User user) {
		if (user.getEmail() != null) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean validatePass(String pass) {
		if (pass.length() < 6) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean isValidUser(User user) {
	UserDaoImplementacija dao = new UserDaoImplementacija();
	user = dao.validateUser(user.getEmail(), user.getPassword());
		if ((!isUserAlreadyRegistered(user))&&(isUserNotNull(user)) && (validatePass(user.getPassword())) ){
			return true;
		} else {
			return false;
		}

	}
	
}
