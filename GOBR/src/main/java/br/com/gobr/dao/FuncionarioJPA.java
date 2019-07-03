package br.com.gobr.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gobr.model.Cliente;
import br.com.gobr.model.Funcionario;

public class FuncionarioJPA {
	// Inicializar a variavel do EntityManager
	private EntityManager em = null;

	// Criar metódo construtor do DAO
	public FuncionarioJPA() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	// Fazer os métodos CRUD a partir daqui

	// Procurar por ID
	public Funcionario getById(final int id) {
		return em.find(Funcionario.class, id);
	}

	// Procurar por nome
	/*public List<Funcionario> getByName(String name) {
		
	}*/
	
	public List<Funcionario> getAll(){
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Funcionario> funcionarios =
				 em.createQuery("FROM " + Funcionario.class.getName()).getResultList();
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
}
