package br.gov.ba.sde.sace.internal.bootstrap;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.BeforeShutdown;
import javax.enterprise.inject.spi.Extension;

import br.gov.ba.sde.sace.internal.util.Beans;

public class CoreBootstrap implements Extension{


	public void beforeBeanDiscovery(@Observes final BeforeBeanDiscovery event) {
	}
	
	public void setBeanManager(@Observes final BeforeBeanDiscovery event, BeanManager beanManager) {
		Beans.setBeanManager(beanManager);
	}

	public void afterDeploymentValidation(@Observes final AfterDeploymentValidation event) {
	}


	public void beforeShutdown(@Observes final BeforeShutdown event) {
	}
	
	
	
	

}
