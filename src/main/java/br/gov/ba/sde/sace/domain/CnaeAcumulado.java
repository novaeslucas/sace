package br.gov.ba.sde.sace.domain;

import java.math.BigInteger;

public class CnaeAcumulado {

    private String codigoCnae;

    private String descricaoCnae;

    private BigInteger qtdAtendimentos;

    public CnaeAcumulado(String codigoCnae, String descricaoCnae, BigInteger qtdAtendimentos){
        this.codigoCnae = codigoCnae;
        this.descricaoCnae = descricaoCnae;
        this.qtdAtendimentos = qtdAtendimentos;
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

    public BigInteger getQtdAtendimentos() {
        return qtdAtendimentos;
    }

    public void setQtdAtendimentos(BigInteger qtdAtendimentos) {
        this.qtdAtendimentos = qtdAtendimentos;
    }
}
