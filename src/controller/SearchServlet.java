package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDaoImplementacija;
import dto.Contacts;
import dto.User;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	ContactDaoImplementacija contacts = new ContactDaoImplementacija();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		User user = (User) request.getSession(false).getAttribute("user");
		int userID = user.getId();

		response.getWriter().print(name);

		ArrayList<Contacts> contactList;

		try {
			contactList = contacts.SearchContacts(name, userID);

			request.getSession().setAttribute("user", user);

			request.getSession().setAttribute("contactList", contactList);

			request.getRequestDispatcher("searchList.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
