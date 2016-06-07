package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.Helper;
import dao.UserDaoImplementacija;
import dto.User;

@WebServlet("/UerLogInServlet")
public class UerLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UerLogInServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDaoImplementacija user = new UserDaoImplementacija();

		User validUser = user.validateUser(email, password);

		if (validUser == null) {
			request.getSession().setAttribute("user", null);
			request.getRequestDispatcher("logIn.jsp").forward(request, response);
			return;

		}
		request.getSession().setAttribute("user", validUser);

		request.getRequestDispatcher("search.jsp").forward(request, response);

	}
}
