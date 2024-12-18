package informaticassa.cat.registra_temps.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Entity
@Table(name="absencia")
@Getter
@Setter
@NoArgsConstructor
public class AbsenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_treballador", referencedColumnName = "id", foreignKey = @ForeignKey(name ="FK_TREBALLADOR_ABSENCIA"))
    private TreballadorEntity treballador;
    @ManyToOne
    @JoinColumn(name="id_tipus_absencia", referencedColumnName = "id", foreignKey = @ForeignKey(name ="FK_TIPUS_ABSENCIA_ABSENCIA"))
    private TipusAbsenciaEntity tipusAbsencia;
    @Column(name="data_inici")
    private Date dataInici;
    @Column(name="hora_inici")
    private Time horaInici;
    @Column(name="data_final")
    private Date dataFinal;
    @Column(name="hora_final")
    private Time horaFinal;
    private boolean esValidada;
    private String observacions;

    public AbsenciaEntity(Long idTreballador, Long idTipusAbsencia, Date dataInici, Time horaInici, Date dataFinal, Time horaFinal, boolean esValidada, String observacions) {
        this.treballador = new TreballadorEntity();
        treballador.setId(idTreballador);
        this.tipusAbsencia = new TipusAbsenciaEntity();
        tipusAbsencia.setId(idTipusAbsencia);
        this.dataInici = dataInici;
        this.horaInici = horaInici;
        this.dataFinal = dataFinal;
        this.horaFinal = horaFinal;
        this.esValidada = esValidada;
        this.observacions = observacions;
    }
}
