package br.com.gobr.dao;

import javax.persistence.EntityManager;
import br.com.gobr.model.Funcionario;

public class FuncionarioJPA {
	// Inicializar a variavel do EntityManager
	private EntityManager em = null;

	// Criar met�do construtor do DAO
	public FuncionarioJPA() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	// Fazer os m�todos CRUD a partir daqui

	// Procurar por ID
	public Funcionario getById(final int id) {
		return em.find(Funcionario.class, id);
	}

	// Salvar
	public void save(Funcionario f) {
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
	}

	// Atualizar
	public void update(Funcionario f) {
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
	}

	// Remover
	public void delete(Funcionario f) {
		em.getTransaction().begin();
		Funcionario funcRemover = getById(f.getIdPessoa());
		em.remove(funcRemover);
		em.getTransaction().commit();
		
	}
}