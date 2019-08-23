package br.gov.ba.sde.sace.bean;

import br.gov.ba.sde.sace.domain.Cnae;
import br.gov.ba.sde.sace.domain.CnaeAcumulado;
import br.gov.ba.sde.sace.domain.Empresa;
import br.gov.ba.sde.sace.internal.util.Faces;
import br.gov.ba.sde.sace.service.AtendimentoService;
import br.gov.ba.sde.sace.service.EmpresaService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class BuscarBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date dataInicial;

    private Date dataFinal;

    private List<CnaeAcumulado> cnaeAcumulados;

    private List<Empresa> empresas;

    private String codigoCnae;

    private String descricaoCnae;

    @Inject
    private AtendimentoService atendimentoService;

    @Inject
    private EmpresaService empresaService;

    public void filtrar(){
        cnaeAcumulados = atendimentoService.filtrar(dataInicial, dataFinal);
    }

    public void initDetalheCnae(){
        if(!Faces.isPostback()){
            String cnae = Faces.getRequest().getAttribute("cnae").toString();
            empresas = new ArrayList<Empresa>();
            empresas = empresaService.obterPorCnae(cnae);
            Cnae result = empresaService.consultarCnae(cnae);
            codigoCnae = result.getCodigo();
            descricaoCnae = result.getDescricao();
        }
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public List<CnaeAcumulado> getCnaeAcumulados() {
        return cnaeAcumulados;
    }

    public void setCnaeAcumulados(List<CnaeAcumulado> cnaeAcumulados) {
        this.cnaeAcumulados = cnaeAcumulados;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public String getCodigoCnae() {
        return codigoCnae;
    }

    public void setCodigoCnae(String codigoCnae) {
        this.codigoCnae = codigoCnae;
    }

    public String getDescricaoCnae() {
        return descricaoCnae;
    }

    public void setDescricaoCnae(String descricaoCnae) {
        this.descricaoCnae = descricaoCnae;
    }
}
