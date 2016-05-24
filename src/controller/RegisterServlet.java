package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.Helper;
import bo.UserImpl;
import dto.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("inputEmail");
		String password = request.getParameter("password");
		String city = request.getParameter("city");

		if (Helper.isValidEmail(email) && Helper.isValidPassword(password)) {

			// create a new user
			User user = new User(name, lastname, password, email, city);

			UserImpl uImpl = new UserImpl();

			try {
				if (uImpl.register(user)) {
					request.getRequestDispatcher("edit.jsp").forward(request, response);
					return;

				} else {
					request.getRequestDispatcher("Added.jsp").forward(request, response);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
