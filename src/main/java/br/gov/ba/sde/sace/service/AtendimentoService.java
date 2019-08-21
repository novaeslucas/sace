package br.gov.ba.sde.sace.service;

import br.gov.ba.sde.sace.domain.Atendimento;
import br.gov.ba.sde.sace.internal.template.ServiceSupport;
import br.gov.ba.sde.sace.persistence.AtendimentoPersistence;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class AtendimentoService extends ServiceSupport<Atendimento, AtendimentoPersistence> {

    private static final long serialVersionUID = 1L;

    @Inject
    private AtendimentoPersistence atendimentoPersistence;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void cadastrar(){

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(){

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(){

    }

    public List<Atendimento> buscar(Atendimento filtros){
        return null;
    }

    @Override
    protected AtendimentoPersistence getPersistence(){
        return atendimentoPersistence;
    }

}
