package br.gov.ba.sde.sace.bean;

import br.gov.ba.sde.sace.domain.Atendimento;
import br.gov.ba.sde.sace.internal.annotation.ViewScoped;
import br.gov.ba.sde.sace.internal.message.SeverityType;
import br.gov.ba.sde.sace.internal.template.ControllerSupport;
import br.gov.ba.sde.sace.internal.util.Faces;
import br.gov.ba.sde.sace.service.AtendimentoService;
import br.gov.ba.sde.sace.util.DateUtil;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Named
@ViewScoped
public class AtendimentoController extends ControllerSupport<Atendimento, AtendimentoService> {

    private static final long serialVersionUID = 1L;

    @Inject
    private AtendimentoService atendimentoService;

    private String csvText;

    public void executarImportacao(){
        if(getCsvText().isEmpty()){
            Faces.addMessage("Arquivo não carregado", SeverityType.ERROR);
        }else{
            String[] linha = getCsvText().split("@sde@");
            Map<String, Date> atendimentos = new HashMap<String, Date>();
            for (int i = 0; i < linha.length; i++) {
                String[] coluna = linha[i].split(";");
                //TODO - verificar o formato da data importada
                atendimentos.put(coluna[0], DateUtil.stringToDate(coluna[1]));
            }
            atendimentoService.importar(atendimentos);
        }
    }

    @Override
    protected AtendimentoService getService(){
        return atendimentoService;
    }

    public String getCsvText() {
        return csvText;
    }

    public void setCsvText(String csvText) {
        this.csvText = csvText;
    }
}
