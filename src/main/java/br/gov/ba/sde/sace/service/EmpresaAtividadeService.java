package br.gov.ba.sde.sace.service;

import br.gov.ba.sde.sace.domain.EmpresaAtividade;
import br.gov.ba.sde.sace.internal.template.ServiceSupport;
import br.gov.ba.sde.sace.persistence.EmpresaAtividadePersistence;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class EmpresaAtividadeService extends ServiceSupport<EmpresaAtividade, EmpresaAtividadePersistence> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EmpresaAtividadePersistence empresaAtividadePersistence;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void cadastrar(){

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(){

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(){

    }

    public List<EmpresaAtividade> buscar(EmpresaAtividade filtros){
        return null;
    }

    @Override
    protected EmpresaAtividadePersistence getPersistence(){
        return empresaAtividadePersistence;
    }

}
