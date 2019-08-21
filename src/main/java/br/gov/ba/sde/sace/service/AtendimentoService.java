package br.gov.ba.sde.sace.service;

import br.gov.ba.sde.sace.domain.Atendimento;
import br.gov.ba.sde.sace.domain.Empresa;
import br.gov.ba.sde.sace.internal.template.ServiceSupport;
import br.gov.ba.sde.sace.persistence.AtendimentoPersistence;
import br.gov.ba.sde.sace.util.DateUtil;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.*;

@Stateless
public class AtendimentoService extends ServiceSupport<Atendimento, AtendimentoPersistence> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EmpresaService empresaService;

    @Inject
    private AtendimentoPersistence atendimentoPersistence;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void cadastrar(Atendimento domain){
        insert(domain);
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

    public void importar(Map<String, Date> atendimentos){
        String[] cnpjs = Arrays.copyOf(atendimentos.keySet().toArray(), atendimentos.keySet().toArray().length, String[].class);
        Date[] dataAtendimentos = Arrays.copyOf(atendimentos.values().toArray(), atendimentos.values().toArray().length, Date[].class);
        for (int i = 0; i < cnpjs.length; i++){
            Empresa empresa = consultarCnpj(cnpjs[i]);
            if(empresa.getCnpj() != null && !empresa.getCnpj().equals("")){
                Atendimento atendimento = new Atendimento();
                atendimento.setAtivo(true);
                atendimento.setDataCadastro(new Date());
                atendimento.setData(dataAtendimentos[i]);
                Empresa aux = empresaService.obterPorCnpj(empresa.getCnpj());
                if(aux == null){
                    cadastrarEmpresa(empresa);
                    atendimento.setEmpresa(empresa);
                }else{
                    atendimento.setEmpresa(aux);
                }
                cadastrar(atendimento);
            }
        }
    }

    public Empresa consultarCnpj(String cnpj){
        return empresaService.consultarCnpj(cnpj);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Empresa cadastrarEmpresa(Empresa empresa){
        empresaService.cadastrar(empresa);
        return empresa;
    }

    @Override
    protected AtendimentoPersistence getPersistence(){
        return atendimentoPersistence;
    }

}
