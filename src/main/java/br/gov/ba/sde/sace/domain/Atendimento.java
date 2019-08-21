package br.gov.ba.sde.sace.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="atendimento", sequenceName="seq_atendimento", allocationSize=1, initialValue=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="atendimento")
    private int id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Atendimento(){
        super();
        this.ativo = true;
        this.empresa = new Empresa();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
