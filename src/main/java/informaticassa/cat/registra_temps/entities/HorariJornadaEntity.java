package informaticassa.cat.registra_temps.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Entity
@Table(name="horari_jornada")
@Getter
@Setter
@NoArgsConstructor
public class HorariJornadaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_jornada", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_HORARI_HORARI_JORNADA"))
    private JornadaEntity jornada;

    private String dia;

    @Column(name="hora_inici")
    private Time horaInici;

    @Column(name="hora_final")
    private Time horaFinal;

    public HorariJornadaEntity(String dia, Time horaInici, Time horaFinal, Long idJornada) {
        this.dia = dia;
        this.horaInici = horaInici;
        this.horaFinal = horaFinal;
        this.jornada =new JornadaEntity();
        this.jornada.setId(idJornada);
    }
}
