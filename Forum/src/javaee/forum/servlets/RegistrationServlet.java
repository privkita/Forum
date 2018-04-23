package javaee.forum.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaee.forum.dao.UsersDAO;
import javaee.forum.entities.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if (login != null && password != null && !password.equals("") && password.equals(password2)) {
			UsersDAO usersDao = (UsersDAO) request.getAttribute("usersDAO");
			try {
				System.out.println("jestem w try i login to: " + login);
				usersDao.getByLogin(login);
				System.out.println("jestem w try po usersDAO i login to: " + login);
				request.setAttribute("error", "Użytkownik o podanym loginie już istnieje");
				doGet(request, response);
				return;
			} catch (Exception nre) {
				System.out.println("jestem w catch i login to: " + login);
				User u = new User();
				u.setLogin(login);
				u.setPassword(password);
				if (usersDao.addUser(u))
					response.sendRedirect(request.getContextPath() + "/index");
				else
					request.setAttribute("error", "Rejestracja zakończona niepowodzeniem");
			}
		} else {
			request.setAttribute("error", "Niepoprawne dane logowania");
			doGet(request, response);
		}
	}

}
