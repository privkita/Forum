package javaee.forum.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaee.forum.dao.SubjectsDAO;
import javaee.forum.entities.Subject;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SubjectsDAO subjectsDao = (SubjectsDAO) request.getAttribute("subjectsDAO");
		List<Subject> subjects = subjectsDao.getSubjects();
		request.setAttribute("subjects", subjects);
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
