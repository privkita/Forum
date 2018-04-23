package javaee.forum.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaee.forum.dao.PostsDAO;
import javaee.forum.dao.SubjectsDAO;
import javaee.forum.entities.Post;
import javaee.forum.entities.Subject;
import javaee.forum.entities.User;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/subject")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stringId = request.getParameter("id"); // ??
		if (stringId != null) {
			int id = Integer.parseInt(stringId);
			SubjectsDAO subjectsDao = (SubjectsDAO) request.getAttribute("subjectsDAO");
			Subject subject = subjectsDao.getSubject(id);
			request.setAttribute("subject", subject);
			request.getRequestDispatcher("WEB-INF/view/subject.jsp").forward(request, response);
 
		} else
			response.sendRedirect(request.getContextPath() + "/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = request.getParameter("content");
		String stringId = request.getParameter("id");
		if (content != null && stringId != null) {
			int id = Integer.parseInt(stringId);
			PostsDAO postsDao = (PostsDAO) request.getAttribute("postsDAO");
			SubjectsDAO subjectsDao = (SubjectsDAO) request.getAttribute("subjectsDAO");
			User loggedIn = (User) request.getSession().getAttribute("user");
			Subject subject = subjectsDao.getSubject(id);
			Post post = new Post();
			post.setDate(new Timestamp(new Date().getTime()));
			post.setContent(content);
			post.setUser_id(loggedIn); //loggedIn.getUser_id
			post.setSubject_id(subject);
			postsDao.addPost(post);
		}
		doGet(request, response);
	}

}
