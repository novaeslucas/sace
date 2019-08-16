package br.gov.ba.sde.sace.bean;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.gov.ba.sde.sace.util.Constants;


@Named("appBean")
@ApplicationScoped
public class ApplicationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String getDefault(){
		return Constants.TEMPLATE_DEFAULT;
	}
	
	public String getCommon(){
		return Constants.TEMPLATE_COMMON;
	}
	
	public String getWarning(){
		return Constants.TEMPLATE_WARNING;
	}
	
	public String getLogin(){
		return Constants.TEMPLATE_LOGIN;
	}
}
