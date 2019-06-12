package br.com.gobr.dao;

import javax.persistence.EntityManager;

import br.com.gobr.model.Pessoa;

public class PessoaJPA {
	private EntityManager em = null;

	public PessoaJPA() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}

	// Fazer os métodos CRUD a partir daqui

	// Procurar por ID
	public Pessoa getById(final int id) {
		return em.find(Pessoa.class, id);
	}

	// Salvar
	public void save(Pessoa p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	// Atualizar
	public void update(Pessoa p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}

	// Remover
	public void delete(Pessoa p) {
		em.getTransaction().begin();
		Pessoa pesRemover = getById(p.getIdPessoa());
		em.remove(pesRemover);
		em.getTransaction().commit();
	}
}
