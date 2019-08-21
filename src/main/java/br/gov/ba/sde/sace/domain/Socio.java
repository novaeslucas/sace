package br.gov.ba.sde.sace.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "socio")
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="socio", sequenceName="seq_socio", allocationSize=1, initialValue=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="socio")
    private int id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Socio(){
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
