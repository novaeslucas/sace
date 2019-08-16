package br.gov.ba.sde.sace.internal.bootstrap;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

import br.gov.ba.sde.sace.internal.context.ViewContext;

public class ViewBootstrap implements Extension {

	public void loadContexts(@Observes final AfterBeanDiscovery event) {
		event.addContext(new ViewContext());
	}
}
