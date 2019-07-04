package br.com.gobr.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.gobr.model.Cliente;

public class ClienteJPA {
	private EntityManager em;
	
	public ClienteJPA() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	public List<Cliente> getAll(){
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Cliente> clientes =
				 em.createQuery("FROM " + Cliente.class.getName()).getResultList();
		System.out.println(clientes);
		return clientes;
	}
	
	// Busca cliente por id no banco de dados
	public Cliente getById(final int id) {
		return em.find(Cliente.class, id);
	}
	
	public List<Cliente> getByName(String nome) {
		em.getTransaction().begin();
		Query q = (Query) em.createNamedQuery("Cliente.findByName");
		q.setParameter("nome", nome);
		List result = q.getResultList();
		em.getTransaction().commit();
		em.close();
		return result;
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