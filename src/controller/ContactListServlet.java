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

/**
 * Servlet implementation class ContactListServlet
 */
@WebServlet("/ContactListServlet")
public class ContactListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession(false).getAttribute("user");
		
		ContactDaoImplementacija dao = new ContactDaoImplementacija();

		ArrayList<Contacts> contactList;
		try {
			contactList = dao.getAllContacts(user.getId());

		request.setAttribute("contactList", contactList);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("contactList.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
