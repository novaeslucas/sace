package br.gov.ba.sde.sace.bean;

import br.gov.ba.sde.sace.domain.Empresa;
import br.gov.ba.sde.sace.internal.annotation.ViewScoped;
import br.gov.ba.sde.sace.internal.template.ControllerSupport;
import br.gov.ba.sde.sace.service.EmpresaService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class EmpresaController extends ControllerSupport<Empresa, EmpresaService> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EmpresaService empresaService;

    @Override
    protected EmpresaService getService() {
        return empresaService;
    }
}
