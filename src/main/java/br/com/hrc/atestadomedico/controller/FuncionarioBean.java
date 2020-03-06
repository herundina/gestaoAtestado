package br.com.hrc.atestadomedico.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.message.Message;
import org.primefaces.component.messages.Messages;

import br.com.hrc.atestadomedico.conversor.FuncionarioConverter;
import br.com.hrc.atestadomedico.model.Funcao;
import br.com.hrc.atestadomedico.model.Funcionario;
import br.com.hrc.atestadomedico.model.Setor;
import br.com.hrc.atestadomedico.repository.Funcionarios;
import br.com.hrc.atestadomedico.service.cadastrarFuncionario;

@Named
@ViewScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Funcionario> listaFuncionarios;
	
	@Inject
	private Funcionarios funcionarios;
	
	@Inject 
	private cadastrarFuncionario cadastroFuncionario;
		
	private FuncionarioConverter converterFuncionario;
	
	private Funcionario funcionario;
	
	private String pesquisa;
	
	private Long id;
		
	public FuncionarioBean() {
		
	}
	
	@PostConstruct
	public void inicializar() {
		this.funcionario = new Funcionario();
	}
	
	//Perssistir Funcionário
	public String salvar() {		
		this.funcionario = this.cadastroFuncionario.salvar(this.funcionario);
		return "paineldefuncionarios?faces-redirect=true";
	}
	
	//Populando TadaTable
	public void listaFuncionarios() {
		listaFuncionarios = funcionarios.todos();				
	}
	
	//Pesquisa 
	public void pesquisar() {			
		this.listaFuncionarios = 
				this.funcionarios.pesquisarFuncionario(pesquisa);
	}
	
	//Navegação Explicita
	public String atualizarCadastro() {
		//this.converterFuncionario = new FuncionarioConverter();
		return "editarfuncionario?faces-redirect=true";				
	}
	
	//Alterar dados
	public void alterarDados() {
		this.funcionarios.pesqId(funcionario.getId());
		
	}
	
	public Setor[] getListaSetor() {
		return Setor.values();
	}
	
	public Funcao[] getListaFuncao() {
		return Funcao.values();
	}
	
	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}