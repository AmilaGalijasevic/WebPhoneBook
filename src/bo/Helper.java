package bo;

import dto.Contacts;
import dto.User;

public class Helper {

	public static boolean isUserNotNull(User user) {
		if (user == null) {
			return false;
		}
		return true;
	}

	public static boolean isValidPassword(String password) {
//		if ((password.length() < 6) || (password.trim() == "")) {
//			return false;
//		}
		return true;
	}

	public static boolean isValidEmail(String email) {
//		if ((email.length() < 2) || (email.trim() == "")) {
//			return false;
//		}
		return true;
	}

	public static boolean isValidUser(User user) {
		if (isUserNotNull(user) && isValidPassword(user.getPassword()) && isValidEmail(user.getEmail())) {
			return true;
		}
		return false;
	}

	public static boolean isContactNotNull(Contacts contact) {
		if (contact == null) {
			return false;
		}
		return true;
	}

	public static boolean isValidId(int userId) {

		if (userId > 0) {
			return true;
		}

		return false;
	}
}
