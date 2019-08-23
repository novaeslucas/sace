package br.gov.ba.sde.sace.persistence;

import br.gov.ba.sde.sace.domain.Atendimento;
import br.gov.ba.sde.sace.domain.CnaeAcumulado;
import br.gov.ba.sde.sace.domain.Empresa;
import br.gov.ba.sde.sace.internal.template.PersistenceSupport;
import br.gov.ba.sde.sace.util.DateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.*;

public class AtendimentoPersistence extends PersistenceSupport<Atendimento> {

    public List<CnaeAcumulado> filtrar(Date dataInicial, Date dataFinal){
        EntityManager em = getEntityManager();
        StringBuilder sql = new StringBuilder();
        sql.append(" select distinct e.codigo_cnae, e.descricao_cnae, count(*) as \"num_atendimentos\" from atendimento as atend ");
        sql.append(" inner join empresa e on atend.empresa_id = e.id ");
        if(dataInicial != null || dataFinal != null){
            sql.append(" where atend.data between '" + DateUtil.dateToStringBDFormat(dataInicial) + "' and '" + DateUtil.dateToStringBDFormat(dataFinal) + "' ");
        }
        sql.append(" group by e.codigo_cnae, e.descricao_cnae order by num_atendimentos desc ");

        Session session = (Session) em.getDelegate();
        Query q = session.createSQLQuery(sql.toString());
        List result = q.list();
        Iterator iterator = result.iterator();
        List<CnaeAcumulado> lista = new ArrayList<CnaeAcumulado>();
        while (iterator.hasNext()) {
            Object[] row = (Object[])iterator.next();
            lista.add(new CnaeAcumulado((String) row[0], (String) row[1], (BigInteger) row[2]));
        }
        return lista;
    }

    public List<Atendimento> obterPorEmpresa(Empresa empresa) {
        String hql = "from Atendimento where empresa.id = :empresaId and ativo = true";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("empresaId", empresa.getId());
        return find(hql, params);
    }

}