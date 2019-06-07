package br.com.gobr.dao;

import javax.persistence.EntityManager;

import br.com.gobr.model.Produto;

public class ProdutoJPA {
	private EntityManager em = null;

	public ProdutoJPA() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	// Fazer os métodos CRUD a partir daqui

	// Procurar por ID
	public Produto getById(final int id) {
		return em.find(Produto.class, id);
	}

	// Salvar
	public void save(Produto p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	// Atualizar
	public void update(Produto p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}

	// Remover
	public void delete(Produto p) {
		em.getTransaction().begin();
		Produto prodRemover = getById(p.getIdProduto());
		em.remove(prodRemover);
		em.getTransaction().commit();
	}
}
