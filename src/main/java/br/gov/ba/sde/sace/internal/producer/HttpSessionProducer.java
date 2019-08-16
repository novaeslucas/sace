package br.gov.ba.sde.sace.internal.producer;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.gov.ba.sde.sace.internal.proxy.HttpSessionProxy;

public class HttpSessionProducer {

	@Produces
	@Default
	@SessionScoped
	public HttpSession create(final HttpServletRequest request) {
		return new HttpSessionProxy(request.getSession());
	}
}
