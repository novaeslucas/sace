package br.gov.ba.sde.sace.internal.template;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.gov.ba.sde.sace.internal.api.Controller;
import br.gov.ba.sde.sace.internal.api.Parameter;
import br.gov.ba.sde.sace.internal.api.Service;
import br.gov.ba.sde.sace.internal.exception.InternalException;
import br.gov.ba.sde.sace.internal.util.Reflections;

public abstract class ControllerSupport<T, E extends Service<T>> implements Controller<T> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@RequestScoped
	private Parameter<Integer> id;
	
	private T domain;
	
	public void init(){
	}	
	
	public T getDomain(){
		if(id != null && id.getValue() != null && domain == null){
			loadDomain();
		} else if(domain == null) {
			domain = getNewInstanceDomain();
		}
		return domain;
	}
	
	public void setDomain(T domain){
		this.domain = domain;
	}
	
	
	private void loadDomain(){
		this.domain = getService().findById(id.getValue());
	}
	
	public T getNewInstanceDomain(){
		T domain = null;
		Class<T> domainClass =  Reflections.getGenericTypeArgument(this.getClass(), 0);
		if(domainClass != null){
			try {
				domain = domainClass.newInstance();
			} catch (Throwable e) {
				throw new InternalException(e.getMessage(), e);
			}
		}
		return domain;
	}
	
	protected abstract E getService();
	
}
