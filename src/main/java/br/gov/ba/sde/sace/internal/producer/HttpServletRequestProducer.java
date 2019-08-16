package br.gov.ba.sde.sace.internal.producer;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;

import br.gov.ba.sde.sace.internal.util.Faces;

public class HttpServletRequestProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Produces
	@RequestScoped
	public HttpServletRequest create() {
		return (HttpServletRequest) Faces.getFacesContext().getExternalContext().getRequest();
	}
}
