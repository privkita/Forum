package javaee.forum.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javaee.forum.entities.Post;

public class PostsDAO {
	private EntityManager em;
	public PostsDAO (EntityManager em) {
		this.em = em;
	}
	
	public boolean addPost(Post p) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(p);
			et.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}
}
