package informaticassa.cat.registra_temps.repositories;

import informaticassa.cat.registra_temps.entities.TreballadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Repository
public interface TreballadorRepository extends JpaRepository<TreballadorEntity, Long> {
    boolean existsByNomUsuari(String nomUsuari);
}
