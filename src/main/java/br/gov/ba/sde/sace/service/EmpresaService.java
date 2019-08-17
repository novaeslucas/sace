package br.gov.ba.sde.sace.service;

import br.gov.ba.sde.sace.domain.Empresa;
import br.gov.ba.sde.sace.internal.template.ServiceSupport;
import br.gov.ba.sde.sace.persistence.EmpresaPersistence;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class EmpresaService extends ServiceSupport<Empresa, EmpresaPersistence> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EmpresaPersistence empresaPersistence;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void cadastrar(){

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(){

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(){

    }

    public List<Empresa> buscar(Empresa filtros){
        return null;
    }

    @Override
    protected EmpresaPersistence getPersistence(){
        return empresaPersistence;
    }

}