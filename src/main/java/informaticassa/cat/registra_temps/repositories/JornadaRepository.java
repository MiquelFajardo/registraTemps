package informaticassa.cat.registra_temps.repositories;

import informaticassa.cat.registra_temps.entities.JornadaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Repository
public interface JornadaRepository extends JpaRepository<JornadaEntity,  Long> {
}

