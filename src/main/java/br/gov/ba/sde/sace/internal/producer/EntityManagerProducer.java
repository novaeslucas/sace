package br.gov.ba.sde.sace.internal.producer;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@RequestScoped
public class EntityManagerProducer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceUnit(name="sace", unitName="sace")
	private EntityManagerFactory emf;

	@PersistenceUnit(name="cnpj", unitName="cnpj")
	private EntityManagerFactory emfCnpj;

	@Produces
	@Default
	@RequestScoped
	public EntityManager create(){
		return emf.createEntityManager();
	}

	@Produces
	@BDCnpj
	@RequestScoped
	public EntityManager createCnpj(){
		return emfCnpj.createEntityManager();
	}
	
	public void dispose(@Disposes EntityManager em){
		if(em != null && em.isOpen()){
			em.close();
		}
	}

}
