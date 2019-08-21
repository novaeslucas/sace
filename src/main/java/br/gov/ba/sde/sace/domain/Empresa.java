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
    private List<Socio> socios;

    @OneToMany(mappedBy="empresa")
    private List<Atendimento> atendimentos;

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

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    public Empresa(){
        super();
        this.ativo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<EmpresaAtividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<EmpresaAtividade> atividades) {
        this.atividades = atividades;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public Date getDataSituacao() {
        return dataSituacao;
    }

    public void setDataSituacao(Date dataSituacao) {
        this.dataSituacao = dataSituacao;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }

    public void setEnderecoLogradouro(String enderecoLogradouro) {
        this.enderecoLogradouro = enderecoLogradouro;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public String getNaturezaJuridica() {
        return naturezaJuridica;
    }

    public void setNaturezaJuridica(String naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getUltimaAtualizacaoCnpj() {
        return ultimaAtualizacaoCnpj;
    }

    public void setUltimaAtualizacaoCnpj(Date ultimaAtualizacaoCnpj) {
        this.ultimaAtualizacaoCnpj = ultimaAtualizacaoCnpj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEfr() {
        return efr;
    }

    public void setEfr(String efr) {
        this.efr = efr;
    }

    public String getMotivoSituacao() {
        return motivoSituacao;
    }

    public void setMotivoSituacao(String motivoSituacao) {
        this.motivoSituacao = motivoSituacao;
    }

    public String getSituacaoEspecial() {
        return situacaoEspecial;
    }

    public void setSituacaoEspecial(String situacaoEspecial) {
        this.situacaoEspecial = situacaoEspecial;
    }

    public Date getDataSituacaoEspecial() {
        return dataSituacaoEspecial;
    }

    public void setDataSituacaoEspecial(Date dataSituacaoEspecial) {
        this.dataSituacaoEspecial = dataSituacaoEspecial;
    }

    public double getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(double capitalSocial) {
        this.capitalSocial = capitalSocial;
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
}
