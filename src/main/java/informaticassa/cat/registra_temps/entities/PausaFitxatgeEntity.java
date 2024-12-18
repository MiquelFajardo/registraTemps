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
@Table(name="pausa_fitxatge")
@Getter
@Setter
@NoArgsConstructor
public class PausaFitxatgeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_fitxatge", referencedColumnName = "id", foreignKey = @ForeignKey(name ="FK_FITXATGE_PAUSA"))
    private FitxatgeEntity fitxatge;
    @ManyToOne
    @JoinColumn(name="id_tipus_pausa", referencedColumnName = "id", foreignKey = @ForeignKey(name ="FK_FITXATGE_TIPUS_PAUSA"))
    private TipusPausaEntity tipusPausa;
    private Time horaInici;
    private Time horaFinal;

    public PausaFitxatgeEntity(Long idFitxatge, Long idTipusPausa, Time horaInici, Time horaFinal) {
        this.fitxatge = new FitxatgeEntity();
        fitxatge.setId(idFitxatge);
        this.tipusPausa = new TipusPausaEntity();
        tipusPausa.setId(idTipusPausa);
        this.horaInici = horaInici;
        this.horaFinal = horaFinal;
    }
}
