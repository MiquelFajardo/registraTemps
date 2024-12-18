package informaticassa.cat.registra_temps.repositories;

import informaticassa.cat.registra_temps.entities.FitxatgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

public interface FitxatgeRepository extends JpaRepository<FitxatgeEntity, Long> {
}
