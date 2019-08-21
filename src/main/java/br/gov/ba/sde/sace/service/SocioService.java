package br.gov.ba.sde.sace.service;

import br.gov.ba.sde.sace.domain.Socio;
import br.gov.ba.sde.sace.internal.template.ServiceSupport;
import br.gov.ba.sde.sace.persistence.SocioPersistence;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class SocioService extends ServiceSupport<Socio, SocioPersistence> {

    private static final long serialVersionUID = 1L;

    @Inject
    private SocioPersistence socioPersistence;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void cadastrar(){

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(){

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(){

    }

    public List<Socio> buscar(Socio filtros){
        return null;
    }

    @Override
    protected SocioPersistence getPersistence(){
        return socioPersistence;
    }

}
