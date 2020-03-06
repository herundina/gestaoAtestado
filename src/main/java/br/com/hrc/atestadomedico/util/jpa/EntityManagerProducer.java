package br.com.hrc.atestadomedico.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.*;

@ApplicationScoped
public class EntityManagerProducer {
	
	private EntityManagerFactory factory;
	
	//Conexão com a unidade de persistencia               
	public EntityManagerProducer() {	
		factory = Persistence.createEntityManagerFactory("gestaoatestado_db");
		System.out.println("Iniciando Conexão");
	}
	
	//Gerenciador de Entity
	@Produces @RequestScoped
	public EntityManager createEntityManager() {
		System.out.println("Iniciando gerenciador Entidade");
		return factory.createEntityManager();
	}
	
	//Close entityManager
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}	
}