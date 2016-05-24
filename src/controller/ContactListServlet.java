package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ContactsImpl;
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

		ContactsImpl contactsImpl = new ContactsImpl();

		ArrayList<Contacts> contacts = contactsImpl.getAllContacts(Integer.parseInt(user.getId()));
		request.setAttribute("contacts", contacts);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("contactList.jsp").forward(request, response);

	}

}
