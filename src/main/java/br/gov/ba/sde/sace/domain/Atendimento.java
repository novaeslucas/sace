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

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
