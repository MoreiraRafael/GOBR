package br.com.gobr.dao;

import javax.persistence.EntityManager;
import br.com.gobr.model.Cliente;

public class ClienteJPA {
	private EntityManager em;
	
	public ClienteJPA() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	// Busca cliente por id no banco de dados
	public Cliente getById(final int id) {
		return em.find(Cliente.class, id);
	}
	
	// Salvar cliente no banco de dados
	public void save(Cliente c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	// Atualizar cliente no banco de dados
	public void update(Cliente c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}
	
	// Remover cliente no banco de dados
	public void delete(Cliente c) {
		em.getTransaction().begin();
		Cliente clienteRemover = getById(c.getIdPessoa());
		em.remove(clienteRemover);
		em.getTransaction().commit();
	}
}