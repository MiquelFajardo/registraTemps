package informaticassa.cat.registra_temps.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Entity
@Table(name="fitxatge")
@Getter
@Setter
@NoArgsConstructor

public class FitxatgeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_treballador", referencedColumnName = "id", foreignKey = @ForeignKey(name ="FK_TREBALLADOR_FITXATGE"))
    private TreballadorEntity treballador;
    private Date data;
    @Column(name = "hora_entrada")
    private Time horaEntrada;
    @Column(name ="hora_sortida")
    private Time horaSortida;

    public FitxatgeEntity(Long idTreballador, Date data, Time horaEntrada, Time horaSortida) {
        this.treballador = new TreballadorEntity();
        treballador.setId(idTreballador);
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSortida = horaSortida;
    }
}