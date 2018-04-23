package javaee.forum.utils;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import javaee.forum.dao.PostsDAO;
import javaee.forum.dao.SubjectsDAO;
import javaee.forum.dao.UsersDAO;

/**
 * Application Lifecycle Listener implementation class DBInitializer
 *
 */
@WebListener
public class DBInitializer implements ServletRequestListener {


    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

    public void requestInitialized(ServletRequestEvent sre)  {
         EntityManager em = DBConfig.createEntityManager();
         UsersDAO usersDAO = new UsersDAO(em);
         SubjectsDAO subjectsDAO = new SubjectsDAO(em);
         PostsDAO postsDAO = new PostsDAO(em);
         ServletRequest req = sre.getServletRequest();
         req.setAttribute("postsDAO", postsDAO);
         req.setAttribute("subjectsDAO", subjectsDAO);
         req.setAttribute("usersDAO", usersDAO);

    }
	
}
