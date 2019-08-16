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

}
