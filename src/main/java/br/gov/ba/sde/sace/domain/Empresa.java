package br.gov.ba.sde.sace.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="empresa", sequenceName="seq_empresa", allocationSize=1, initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="empresa")
    private int id;

    @OneToMany(mappedBy="empresa")
    private List<EmpresaAtividade> atividades;

    @OneToMany(mappedBy="empresa")
    private List<Socio> socio;

    @Column(name = "data_situacao")
    private Date dataSituacao;

    @Column(name = "endereco_complemento")
    private String enderecoComplemento;

    @Column(name = "nome")
    private String nome;

    @Column(name = "uf")
    private String uf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "situacao")
    private String situacao;

    @Column(name = "endereco_bairro")
    private String enderecoBairro;

    @Column(name = "endereco_logradouro")
    private String enderecoLogradouro;

    @Column(name = "endereco_numero")
    private String enderecoNumero;

    @Column(name = "cep")
    private String cep;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "porte")
    private String porte;

    @Column(name = "abertura")
    private Date abertura;

    @Column(name = "natureza_juridica")
    private String naturezaJuridica;

    @Column(name = "fantasia")
    private String fantasia;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "ultima_atualizacao_cnpj")
    private Date ultimaAtualizacaoCnpj;

    @Column(name = "status")
    private String status;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "efr")
    private String efr;

    @Column(name = "motivo_situacao")
    private String motivoSituacao;

    @Column(name = "situacao_especial")
    private String situacaoEspecial;

    @Column(name = "data_situacao_especial")
    private Date dataSituacaoEspecial;

    @Column(name = "capital_social")
    private double capitalSocial;
}
