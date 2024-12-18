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
@Table (name="treballador")
@Getter
@Setter
@NoArgsConstructor

public class TreballadorEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Column(name="cognom_1")
    private String cognom1;
    @Column(name="cognom_2")
    private String cognom2;
    private String nif;
    @Column(name="nom_usuari")
    private String nomUsuari;
    private String contrasenya;
    private boolean administrador;
    private boolean actiu;

    @OneToMany (mappedBy = "treballador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TreballadorJornadaEntity> jornades = new ArrayList<>();

    @OneToMany (mappedBy = "treballador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FitxatgeEntity> fitxatges = new ArrayList<>();

    public TreballadorEntity(String nom, String cognom1, String cognom2, String nif, String nomUsuari, String contrasenya, boolean administrador, boolean actiu) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.nif = nif;
        this.nomUsuari = nomUsuari;
        this.contrasenya = contrasenya;
        this.administrador = administrador;
        this.actiu = actiu;
    }
}
