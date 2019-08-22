package br.gov.ba.sde.sace.bean;

import br.gov.ba.sde.sace.domain.CnaeAcumulado;
import br.gov.ba.sde.sace.service.AtendimentoService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class FiltrarBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date dataInicial;

    private Date dataFinal;

    private List<CnaeAcumulado> cnaeAcumulados;

    @Inject
    private AtendimentoService atendimentoService;

    public void filtrar(){
        cnaeAcumulados = atendimentoService.filtrar(dataInicial, dataFinal);
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
}
