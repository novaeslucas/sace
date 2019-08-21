package br.gov.ba.sde.sace.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empresa_atividade")
public class EmpresaAtividade  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="empresa_atividade", sequenceName="seq_empresa_atividade", allocationSize=1, initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="empresa_atividade")
    private int id;

    @Column(name = "descricao", length = 1000, nullable = false)
    private String descricao;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "principal", nullable = false)
    private boolean principal;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public EmpresaAtividade(){
        this.ativo = true;
        this.empresa = new Empresa();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
