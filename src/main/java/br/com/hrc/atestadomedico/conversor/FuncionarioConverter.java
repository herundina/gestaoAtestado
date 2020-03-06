package br.com.hrc.atestadomedico.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.hrc.atestadomedico.model.Funcionario;
import br.com.hrc.atestadomedico.repository.Funcionarios;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {

	@Inject
	private Funcionarios funcionarios;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
		Funcionario retorno = null;
		
		if(valor != null) {
			retorno = this.funcionarios.pesqId(new Long (valor));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}