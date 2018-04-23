package javaee.forum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javaee.forum.entities.Subject;

public class SubjectsDAO {
	
	private EntityManager em;
	
	public SubjectsDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<Subject> getSubjects() {
		List<Subject> subjects = this.em.createQuery("SELECT s from Subject s").getResultList();
		return subjects;
	}
	
	public Subject getSubject(int id) {
		this.em.clear();
		return this.em.find(Subject.class, id);
	}
	
	public boolean addSubject(Subject s) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(s);
			et.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}
}
