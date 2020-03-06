package br.com.hrc.atestadomedico.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hrc.atestadomedico.conversor.FuncionarioConverterAutoComplete;
import br.com.hrc.atestadomedico.conversor.FuncionarioConverterMatricula;
import br.com.hrc.atestadomedico.model.Atestado;
import br.com.hrc.atestadomedico.model.Funcionario;
import br.com.hrc.atestadomedico.repository.Atestados;
import br.com.hrc.atestadomedico.repository.Funcionarios;
import br.com.hrc.atestadomedico.service.CadastroAtestadoService;
import br.com.hrc.atestadomedico.util.jsf.FacesUtil;

@Named
@ViewScoped
public class AtestadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;
	private Atestado atestado;

	@Inject
	private Atestados atestados;

	@Inject
	private Funcionarios funconarios;

	private List<Atestado> listaAtestado;
	
	@Inject
	private CadastroAtestadoService cadastroAtestadoService;

	private Converter funcionarioConverterComplete;
	
	private Converter funcionarioConverterMatricula;

	private int qtidadedias;
	
	public AtestadoBean() {

	}

	@PostConstruct
	public void inicializar() {		
		this.atestado = new Atestado();
	}

	public String salvar() {
		this.cadastroAtestadoService.salvar(atestado);
		
		FacesUtil.addInfoMessage("Atestado Lançado com Sucesso!");		
		return "painelAtestado?faces-redirect=true";
	}

	public List<Funcionario> completarPesquisa(String pesquisa) {
		List<Funcionario> listafuncionario 
					= this.funconarios.pesquisarFuncionario(pesquisa);
		this.funcionarioConverterComplete 
					= new FuncionarioConverterAutoComplete(listafuncionario);
		return listafuncionario;
	}
	
	public List<Funcionario> retornarMatricula(String matricula){
		List<Funcionario> listaMatricula = 
				this.funconarios.pesquisarMatricula(matricula);
		this.funcionarioConverterMatricula = 
				new FuncionarioConverterMatricula(listaMatricula);
		return listaMatricula;
	}
	
	public void listaAtestado() {
		this.listaAtestado = this.atestados.todosAtestado();
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Atestado getAtestado() {
		return atestado;
	}

	public void setAtestado(Atestado atestado) {
		this.atestado = atestado;
	}

	public Converter getFuncionarioConverterComplete() {
		return funcionarioConverterComplete;
	}

	public void setFuncionarioConverterComplete(Converter funcionarioConverterComplete) {
		this.funcionarioConverterComplete = funcionarioConverterComplete;
	}
	
	public Converter getFuncionarioConverterMatricula() {
		return funcionarioConverterMatricula;
	}

	public void setFuncionarioConverterMatricula(Converter funcionarioConverterMatricula) {
		this.funcionarioConverterMatricula = funcionarioConverterMatricula;
	}

	public List<Atestado> getListaAtestado() {
		return listaAtestado;
	}

	public void setListaAtestado(List<Atestado> listaAtestado) {
		this.listaAtestado = listaAtestado;
	}

	public int getQtidadedias() {
		return qtidadedias;
	}

	public void setQtidadedias(int qtidadedias) {
		this.qtidadedias = qtidadedias;
	}
}