package informaticassa.cat.registra_temps.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Entity
@Table(name="tipus_pausa")
@Getter
@Setter
@NoArgsConstructor

public class TipusPausaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private boolean actiu;

    public TipusPausaEntity(String nom, boolean actiu) {
        this.nom = nom;
        this.actiu = actiu;
    }
}