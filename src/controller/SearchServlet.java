package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ContactsImpl;
import dto.Contacts;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	ContactsImpl contactBO = new ContactsImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		response.getWriter().print(name);

		ArrayList<Contacts> contacts;
		try {
			contacts = contactBO.SearchContacts(name, id);
			request.setAttribute("contacts", contacts);
			request.getRequestDispatcher("contactList.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
