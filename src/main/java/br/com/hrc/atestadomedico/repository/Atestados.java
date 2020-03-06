package br.com.hrc.atestadomedico.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.hrc.atestadomedico.model.Atestado;

public class Atestados implements Serializable{
	
	@Inject
	private EntityManager manager;
	
	public Atestados() {
		
	}
	
	public Atestados(EntityManager manager) {
		this.manager = manager;
	}
		
	public Atestado salvarAtestado(Atestado novoAtestado) {	
		return this.manager.merge(novoAtestado);
	}
	
	//Pesquisar Por ID
	public Atestado pesqId(Long id) {
		return this.manager.find(Atestado.class, id);
	}
	
	//Pesquisar all atestado ArrayList
	public List<Atestado> todosAtestado(){
		TypedQuery<Atestado> query
			= manager.createQuery("from Atestado" , Atestado.class);
		 return query.getResultList();
	}
	
	//Deletar atestado, dentro do contexto do EntityManger
	public void deletarAtestado(Atestado atestado) {
		pesqId(atestado.getId());
		this.manager.remove(atestado);		
	}
}