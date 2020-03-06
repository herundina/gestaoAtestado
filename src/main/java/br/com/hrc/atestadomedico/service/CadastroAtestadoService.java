package br.com.hrc.atestadomedico.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import br.com.hrc.atestadomedico.model.Atestado;
import br.com.hrc.atestadomedico.model.Funcionario;
import br.com.hrc.atestadomedico.repository.Atestados;
import br.com.hrc.atestadomedico.util.jpa.Transactional;

public class CadastroAtestadoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Atestados atestados;
	
	private Atestado atestado;
	private int qtidadedias;

	@Transactional
	public Atestado salvar(Atestado atestado) {
		System.out.println("Método salvar, Atestado Service");
		return this.atestados.salvarAtestado(atestado);
	}	
	
	/*
	@Transactional
	public Atestado excluirRegistro(Atestado atestado) {
		return this.atestados.deletarAtestado(atestado);
	}*/
	
	public Integer qtidadeDias() {		
		Calendar dtinicio = Calendar.getInstance();
		Calendar dtFim = Calendar.getInstance();
		
			dtinicio.setTime(atestado.getDtDiaInicio());
			dtFim.setTime(atestado.getDtDiaFim());
			
				this.qtidadedias =
					(dtFim.get(Calendar.DAY_OF_WEEK) - 
								dtinicio.get(Calendar.DAY_OF_WEEK));
				return qtidadedias;				
	}
}