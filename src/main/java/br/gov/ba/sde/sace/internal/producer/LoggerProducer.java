package br.gov.ba.sde.sace.internal.producer;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import br.gov.ba.sde.sace.internal.proxy.Slf4jLoggerProxy;

public class LoggerProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	public <T> org.slf4j.Logger create(Class<T> clazz) {
		org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(clazz);
		return new Slf4jLoggerProxy(logger);
	}

	@Produces
	@Default
	public org.slf4j.Logger create(final InjectionPoint injectionPoint) {
		return create(injectionPoint.getMember().getDeclaringClass());
	}
	
}
