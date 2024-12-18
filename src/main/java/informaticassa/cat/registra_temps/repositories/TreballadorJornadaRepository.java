package informaticassa.cat.registra_temps.repositories;

import informaticassa.cat.registra_temps.entities.TreballadorJornadaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

public interface TreballadorJornadaRepository extends JpaRepository<TreballadorJornadaEntity, Long> {
}
