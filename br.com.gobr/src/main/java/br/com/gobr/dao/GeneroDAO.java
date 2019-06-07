package br.com.gobr.dao;

import javax.persistence.EntityManager;

import br.com.gobr.model.Genero;

public class GeneroDAO {
	private EntityManager em = null;
	
	public GeneroDAO() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	public Genero getById(final int id) {
		return em.find(Genero.class, id);
	}
	
	public void save(Genero g) {
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
	}
	
	public void update(Genero g) {
		em.getTransaction().begin();
		em.merge(g);
		em.getTransaction().commit();
	}
	
	public void delete(Genero g) {
		em.getTransaction().begin();
		Genero generoRemover = getById(g.getIdGenero());
		em.remove(generoRemover);
		em.getTransaction().commit();
	}
}
