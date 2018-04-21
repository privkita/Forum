package javaee.forum.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaee.forum.dao.SubjectsDAO;
import javaee.forum.entities.Subject;
import javaee.forum.entities.User;

/**
 * Servlet implementation class NewSubjectServlet
 */
@WebServlet("/newSubject")
public class NewSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/newSubject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if (!title.equals("") && !content.equals("")) {
			Timestamp t = new Timestamp(new Date().getTime());
			User loggedIn = (User) request.getSession().getAttribute("user");
			SubjectsDAO subjectsDao = (SubjectsDAO) request.getAttribute("subjectsDAO");
			Subject subject = new Subject();
			subject.setDate(t);
			subject.setContent(content);
			subject.setTitle(title);
			subject.setUser_id(loggedIn);
			if (subjectsDao.addSubject(subject))
				response.sendRedirect(request.getContextPath() + "/subject?id=" + subject.getSubject_id());
		}
	}

}
