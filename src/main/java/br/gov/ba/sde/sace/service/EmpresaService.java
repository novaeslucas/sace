package br.gov.ba.sde.sace.service;

import br.gov.ba.sde.sace.domain.Cnae;
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
    public void cadastrar(Empresa domain){
        empresaPersistence.insert(domain);
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

    public Empresa consultarCnpj(String cnpj){
        return empresaPersistence.consultarCnpj(cnpj);
    }

    public Empresa obterPorCnpj(String cnpj){
        return empresaPersistence.obterPorCnpj(cnpj);
    }

    public List<Empresa> obterPorCnae(String cnae){
        return empresaPersistence.obterPorCnae(cnae);
    }

    public Cnae consultarCnae(String cnae){
        return empresaPersistence.consultarCnae(cnae);
    }

    @Override
    protected EmpresaPersistence getPersistence(){
        return empresaPersistence;
    }

}
