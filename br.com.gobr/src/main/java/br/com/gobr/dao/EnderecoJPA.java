package br.com.gobr.dao;

import javax.persistence.EntityManager;

import br.com.gobr.model.Endereco;

public class EnderecoJPA {
	private EntityManager em = null;
	
	public EnderecoJPA() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	// Fazer os métodos CRUD a partir daqui

	// Procurar por ID
	public Endereco getById(final int id) {
		return em.find(Endereco.class, id);
	}

	// Salvar
	public void save(Endereco e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}

	// Atualizar
	public void update(Endereco e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}

	// Remover
	public void delete(Endereco e) {
		em.getTransaction().begin();
		Endereco endRemover = getById(e.getIdEndereco());
		em.remove(endRemover);
		em.getTransaction().commit();
	}
}
