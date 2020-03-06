package br.com.hrc.atestadomedico.conversor;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.hrc.atestadomedico.model.Funcionario;

public class FuncionarioConverterAutoComplete implements Converter {

	private List<Funcionario> listafuncionario;
	
	public FuncionarioConverterAutoComplete(List<Funcionario> listafuncionario) {
		this.listafuncionario = listafuncionario;
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String identificador) {
		
		if(identificador == null) {
			return null;
		}
	
		Long id = Long.valueOf(identificador);
		
		for(Funcionario funcionario: listafuncionario) {
			if(id.equals(funcionario.getId())) {
				return funcionario.getNome();
			}
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valorId) {
		
		if(valorId == null) {
			return null;
		}
		//Cast
		Funcionario funcionario = (Funcionario) valorId;
		
		return funcionario.getId().toString();
	}
}