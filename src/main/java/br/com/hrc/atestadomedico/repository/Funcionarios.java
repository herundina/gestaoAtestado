package br.com.hrc.atestadomedico.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.hrc.atestadomedico.model.Funcionario;

public class Funcionarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Funcionarios() {

	}

	public Funcionarios(EntityManager manager) {
		this.manager = manager;
	}
	
	public Funcionario teste(Funcionario funcionario) {
		System.out.println("Repository Funcionario, " +funcionario);
		return manager.merge(funcionario);
	}

	// Pesquisar por Id
	public Funcionario pesqId(Long id) {
		return this.manager.find(Funcionario.class, id);
	}

	// Pesquisar all Funcionarios
	public List<Funcionario> pesquisarFuncionario(String pesquisa) {	
		TypedQuery<Funcionario> query = 
				manager.createQuery("from Funcionario as f "
						+ "where f.nome like :nome", Funcionario.class);
						query.setParameter("nome", pesquisa + "%");				
			return query.getResultList();
	}

	public List<Funcionario> pesquisarMatricula(String matricula){		
		TypedQuery<Funcionario> query = 
				manager.createQuery("from Funcionario as f "
						+ "where f.matricula like :matricula", Funcionario.class);
						query.setParameter("matricula", matricula + "%");					
		return query.getResultList();		
	}
	
	// Retornar todos os funcionarios
	public List<Funcionario> todos() {
		return manager.createQuery("from Funcionario", Funcionario.class).getResultList();
	}

	// Add Funcionarios
	public void removerFuncionario(Funcionario funcionario) {
		pesqId(funcionario.getId());
		manager.remove(funcionario);
	}
}