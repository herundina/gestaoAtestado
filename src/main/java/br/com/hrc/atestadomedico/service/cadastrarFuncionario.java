package br.com.hrc.atestadomedico.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.hrc.atestadomedico.model.Funcionario;
import br.com.hrc.atestadomedico.repository.Funcionarios;
import br.com.hrc.atestadomedico.util.jpa.Transactional;

public class cadastrarFuncionario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private Funcionarios funcionarios;
	
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		System.out.println("Service Funcionario, " +funcionario);
		 return funcionarios.teste(funcionario);
	}	
}