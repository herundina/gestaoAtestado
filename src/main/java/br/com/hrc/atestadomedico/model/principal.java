package br.com.hrc.atestadomedico.model;

import javax.persistence.EntityManager;

import br.com.hrc.atestadomedico.repository.Funcionarios;
import br.com.hrc.atestadomedico.service.cadastrarFuncionario;
import br.com.hrc.atestadomedico.util.jpa.EntityManagerProducer;

public class principal {

	public static void main(String[] args) {
		
		EntityManagerProducer produtor= new EntityManagerProducer();
		EntityManager manager = produtor.createEntityManager();
		
		/*Funcionarios fc = new Funcionarios(manager);
		String nome = "5546546";
		fc.pesquisarFuncionario(nome);*/
	
		produtor.closeEntityManager(manager);
	}
}