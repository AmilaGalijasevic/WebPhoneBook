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
 * Servlet implementation class EditContactServlet
 */
@WebServlet("/EditContactServlet")
public class EditContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditContactServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	ContactDaoImplementacija dao = new ContactDaoImplementacija();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int id =Integer.parseInt( request.getParameter("id"));
	
	//	String name = request.getParameter("name");
		Contacts contactList;
		try {
			contactList = dao.readContact(id);
			request.setAttribute("contactList", contactList);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");

		Contacts contact = new Contacts();
		contact.setId(id);
		contact.setName(name);
		contact.setLastname(lastname);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setCity(city);
		
		try {
			if(dao.updateContacts(contact)){
			
			request.getRequestDispatcher("edited.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
