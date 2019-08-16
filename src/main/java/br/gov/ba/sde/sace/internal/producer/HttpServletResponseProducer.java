package br.gov.ba.sde.sace.internal.producer;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletResponse;

import br.gov.ba.sde.sace.internal.util.Faces;

public class HttpServletResponseProducer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Produces
	@RequestScoped
	public HttpServletResponse create() {
		return (HttpServletResponse) Faces.getFacesContext().getExternalContext().getResponse();
	}

}
