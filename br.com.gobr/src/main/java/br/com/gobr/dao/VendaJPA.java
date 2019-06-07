package br.com.gobr.dao;

import javax.persistence.EntityManager;

import br.com.gobr.model.Compra;
import br.com.gobr.model.Venda;

public class VendaJPA {
	private EntityManager em = null;

	public VendaJPA() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}

	// Fazer os métodos CRUD a partir daqui

	// Procurar por ID
	public Venda getById(final int id) {
		return em.find(Venda.class, id);
	}
	
	// Salvar
	public void save(Venda v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

	// Atualizar
	public void update(Venda v) {
		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
	}

	// Remover
	public void delete(Venda v) {
		em.getTransaction().begin();
		Venda vendRemover = getById(v.getIdVenda());
		em.remove(vendRemover);
		em.getTransaction().commit();
	}
}
