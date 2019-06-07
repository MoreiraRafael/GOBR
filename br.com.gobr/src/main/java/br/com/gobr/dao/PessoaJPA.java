package br.com.gobr.dao;

import javax.persistence.EntityManager;

import br.com.gobr.model.Cliente;

public class PessoaJPA {
	private EntityManager em;
	
	public PessoaJPA() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	public Cliente getById(final int id) {
		return em.find(Cliente.class, id);
	}
}
