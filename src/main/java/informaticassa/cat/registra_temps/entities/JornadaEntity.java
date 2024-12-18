package informaticassa.cat.registra_temps.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Entity
@Table(name="jornada")
@Getter
@Setter
@NoArgsConstructor
public class JornadaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Column(name="hores_diaries")
    private double horesDiaries;

    private String observacions;

    @OneToMany(mappedBy = "jornada", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TreballadorJornadaEntity> treballadors = new ArrayList<>();

    public JornadaEntity(String nom, double horesDiaries, String observacions) {
        this.nom = nom;
        this.horesDiaries = horesDiaries;
        this.observacions = observacions;
    }
}
