package br.gov.ba.sde.sace.persistence;

import br.gov.ba.sde.sace.domain.Cnae;
import br.gov.ba.sde.sace.domain.Empresa;
import br.gov.ba.sde.sace.internal.template.PersistenceSupport;
import br.gov.ba.sde.sace.util.DateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmpresaPersistence extends PersistenceSupport<Empresa> {

    public Empresa consultarCnpj(String cnpj){
        EntityManager em = getEntityManagerCnpj();
        String consultarCnpj = "select e.complemento as \"complemento\", " +
                "e.razao_social as \"razao_social\", " +
                "e.uf as \"uf\", " +
                "e.bairro as \"bairro\", " +
                "e.logradouro as \"logradouro\", " +
                "e.numero as \"numero\", " +
                "e.cep as \"cep\", " +
                "e.municipio as \"municipio\", " +
                "e.data_inicio_atividade as \"data_inicio_atividade\", " +
                "e.nome_fantasia as \"nome_fantasia\", " +
                "e.cnpj as \"cnpj\", " +
                "c.codigo as \"codigo_cnae_principal\", " +
                "c.descricao as \"descricao_cnae_principal\" " +
                "from empresa as e inner join cnae as c on e.cnae_fiscal = c.codigo where e.cnpj = '" + cnpj + "';";
        Session session = (Session) em.getDelegate();
        Query q = session.createSQLQuery(consultarCnpj);
        List result = q.list();
        Empresa empresa = new Empresa();
        if(result.size() > 0){
            Iterator iterator = result.iterator();
            while (iterator.hasNext()) {
                Object[] row = (Object[])iterator.next();
                empresa.setEnderecoComplemento((String)row[0]);
                empresa.setNome((String) row[1]);
                empresa.setUf((String) row[2]);
                empresa.setEnderecoBairro((String) row[3]);
                empresa.setEnderecoLogradouro((String) row[4]);
                empresa.setEnderecoNumero((String) row[5]);
                empresa.setCep((String) row[6]);
                empresa.setMunicipio((String) row[7]);
                empresa.setAbertura(DateUtil.stringToDateBDFormat((String) row[8]));
                empresa.setFantasia((String) row[9]);
                empresa.setCnpj((String) row[10]);
                empresa.setCodigoCnae((String) row[11]);
                empresa.setDescricaoCnae((String) row[12]);
            }
        }
        return empresa;
    }

    public Empresa obterPorCnpj(String cnpj) {
        String hql = "from Empresa where cnpj = :cnpj and ativo = true";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("cnpj", cnpj);
        List<Empresa> result = find(hql, params);
        if(result.size() > 0){
            return result.get(0);
        }else{
            return null;
        }
    }

    public List<Empresa> obterPorCnae(String cnae) {
        String hql = "from Empresa where codigoCnae = :codigoCnae and ativo = true";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("codigoCnae", cnae);
        return find(hql, params);
    }

    public Cnae consultarCnae(String cnae){
        EntityManager em = getEntityManagerCnpj();
        String consultarCnpj = "select c.codigo as \"codigo\", " +
                "c.descricao as \"descricao\" " +
                "from cnae as c where c.codigo = '" + cnae + "';";
        Session session = (Session) em.getDelegate();
        Query q = session.createSQLQuery(consultarCnpj);
        List result = q.list();
        Cnae temp = null;
        if(result.size() > 0){
            Iterator iterator = result.iterator();
            while (iterator.hasNext()) {
                Object[] row = (Object[])iterator.next();
                temp = new Cnae((String)row[0], (String)row[1]);
            }
        }
        return temp;
    }
}
