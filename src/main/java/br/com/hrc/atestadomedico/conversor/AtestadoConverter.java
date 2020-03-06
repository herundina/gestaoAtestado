package br.com.hrc.atestadomedico.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.hrc.atestadomedico.model.Atestado;
import br.com.hrc.atestadomedico.repository.Atestados;

@FacesConverter(forClass = Atestado.class)
public class AtestadoConverter implements Converter{

	@Inject
	private Atestados atestados; 
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valorId) {
		Atestado retorno = null;
		
		//Long id = Long.valueOf(valorId);
		
		if(valorId !=null) {
			retorno = this.atestados.pesqId(new Long(valorId));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
