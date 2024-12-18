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
@Table(name="modificacio_fitxatge")
@Getter
@Setter
@NoArgsConstructor
public class ModificacioFitxatgeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_fitxatge", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_FITXATGE_MODIFICACIO_FITXATGE"))
    private FitxatgeEntity fitxatge;

    @ManyToOne
    @JoinColumn(name="id_treballador", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_FITXATGE_MODIFICACIO_TREBALLADOR"))
    private TreballadorEntity treballador;

    @Column(name="hora_entrada_antiga")
    private Time horaEntradaAntiga;
    @Column(name="hora_sortida_antiga")
    private Time horaSortidaAntiga;

    public ModificacioFitxatgeEntity(Long idFitxatge, Long idTreballador, Time horaEntradaAntiga, Time horaSortidaAntiga) {
        this.fitxatge = new FitxatgeEntity();
        fitxatge.setId(idFitxatge);
        this.treballador = new TreballadorEntity();
        treballador.setId(idTreballador);
        this.horaEntradaAntiga = horaEntradaAntiga;
        this.horaSortidaAntiga = horaSortidaAntiga;
    }
}