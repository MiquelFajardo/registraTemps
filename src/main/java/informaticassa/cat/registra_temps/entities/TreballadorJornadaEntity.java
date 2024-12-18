package informaticassa.cat.registra_temps.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Entity
@Table(name="treballador_jornada")
@Getter
@Setter
@NoArgsConstructor
public class TreballadorJornadaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_treballador", referencedColumnName = "id", foreignKey = @ForeignKey(name ="FK_TREBALLADOR_TREBALLADOR_JORNADA"))
    private TreballadorEntity treballador;

    @ManyToOne
    @JoinColumn(name="id_jornada", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_JORNADA_TREBALLADOR_JORNADA"))
    private JornadaEntity jornada;

    @Column(name = "data_inici")
    private Date dataInici;
    @Column(name = "data_final")
    private Date dataFinal;

    public TreballadorJornadaEntity(Long idTreballador, Long idJornada, Date dataInici, Date dataFinal) {
        this.treballador = new TreballadorEntity();
        treballador.setId(idTreballador);
        this.jornada = new JornadaEntity();
        jornada.setId(idJornada);
        this.dataInici = dataInici;
        this.dataFinal = dataFinal;
    }
}

