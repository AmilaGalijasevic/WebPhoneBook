package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDaoImplementacija;
import dto.Contacts;
import dto.User;

/**
 * Servlet implementation class AddContactsServlet
 */
@WebServlet("/AddContactsServlet")
public class AddContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddContactsServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user =  (User) request.getSession(false).getAttribute("user");

		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");

		Contacts contact = new Contacts();

		contact.setName(name);
		contact.setLastname(lastname);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setCity(city);

		//ContactsImpl cImpl = new ContactsImpl();
		ContactDaoImplementacija cImpl = new ContactDaoImplementacija();
		try {
			if (cImpl.AddContacts(contact, user.getId())) {
				request.getSession().setAttribute("user", user);
			//	request.setAttribute("name", name);
				response.sendRedirect("Added.jsp");
			} else {
				request.getRequestDispatcher("search.jsp").forward(request, response);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
