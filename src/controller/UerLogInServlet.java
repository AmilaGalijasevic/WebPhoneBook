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

@WebServlet("/LogInServlet")
public class UerLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UerLogInServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = null;
		
		if (Helper.isValidEmail(email)&& Helper.isValidPassword(password)) {

			UserImpl userBO = new UserImpl();

			try {
				user =userBO.validateUser(email, password);
				if (userBO.validateUser(email, password)== null) {
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return; 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("search.jsp").forward(request, response);
			return; // end the execution of the doPost

		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

		
		
		

}
