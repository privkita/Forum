package javaee.forum.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaee.forum.dao.UsersDAO;
import javaee.forum.entities.User;

/**
 * Servlet Filter implementation class LoggInFilter
 */
@WebFilter("/*")
public class LoggInFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		String login = req.getRemoteUser();
		if (login != null) {
			User u = (User) req.getSession().getAttribute("user");
			if (u == null) {
				UsersDAO usersDao = (UsersDAO) req.getAttribute("usersDao");
				u = usersDao.getByLogin(login);
				req.getSession().setAttribute("user", u);
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
