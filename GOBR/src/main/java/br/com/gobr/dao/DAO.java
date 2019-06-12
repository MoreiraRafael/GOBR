package br.com.gobr.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
	private EntityManager em = null;
	
	public DAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gobrPU");
		if(em == null) {
			em = emf.createEntityManager();
		}
	}
	
	public EntityManager getEntity() {
		return em;
	}
}
