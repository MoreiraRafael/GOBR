package br.com.gobr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	// Procurar por nome
	/*
	 * public List<Funcionario> getByName(String name) {
	 * 
	 * }
	 */

	public List<Funcionario> getAll() {
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Funcionario> funcionarios = em.createQuery("FROM " + Funcionario.class.getName()).getResultList();
		return funcionarios;
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

	// Gerar o login
	public boolean getLogin(String usuario, String senha) {
		boolean autenticate = false;
		String sql = "FROM Funcionario f WHERE f.nomeusuario = :nomeusuario and f.senha = :senha";
		Query sqlLogin = em.createQuery(sql);
		sqlLogin.setParameter("nomeusuario", usuario);
		sqlLogin.setParameter("senha", senha);
		
		@SuppressWarnings("unchecked")
		List<Funcionario> loginUser = sqlLogin.getResultList();

		if (loginUser.size() > 0) {
			return true;
		}
		return autenticate;
	}
}
