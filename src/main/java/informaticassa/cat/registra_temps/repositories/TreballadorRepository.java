package informaticassa.cat.registra_temps.repositories;

import informaticassa.cat.registra_temps.entities.TreballadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Repository
public interface TreballadorRepository extends JpaRepository<TreballadorEntity, Long> {
    boolean existsByNomUsuari(String nomUsuari);

    @Query("SELECT t.id FROM TreballadorEntity t WHERE t.nomUsuari = :nomUsuari AND t.contrasenya = :contrasenya AND t.actiu = true")
    Long autenticar(@Param("nomUsuari") String nomUsuari, @Param("contrasenya") String contrasenya);
}

