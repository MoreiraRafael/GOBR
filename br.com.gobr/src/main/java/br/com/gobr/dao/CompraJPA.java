package br.com.gobr.dao;

import javax.persistence.EntityManager;

import br.com.gobr.model.Compra;

public class CompraJPA {
	// Inicializar a variavel do EntityManager
	private EntityManager em = null;

	// Criar metódo construtor do DAO
	public CompraJPA() {
			DAO dao = new DAO();
			em = dao.getEntity();
		}
	// Fazer os métodos CRUD a partir daqui

	// Procurar por ID
	public Compra getById(final int id) {
		return em.find(Compra.class, id);
	}

	// Salvar
	public void save(Compra c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}

	// Atualizar
	public void update(Compra c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}

	// Remover
	public void delete(Compra c) {
		em.getTransaction().begin();
		Compra compRemover = getById(c.getIdCompra());
		em.remove(compRemover);
		em.getTransaction().commit();
	}
}
