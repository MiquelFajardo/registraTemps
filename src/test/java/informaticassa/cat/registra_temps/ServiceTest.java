package informaticassa.cat.registra_temps;

import informaticassa.cat.registra_temps.entities.TreballadorEntity;
import informaticassa.cat.registra_temps.services.GenerarNomUsuariService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@SpringBootTest(classes=RegistraTempsApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {
    @Autowired
    GenerarNomUsuariService generarNomUsuariService;

    @Test
    @Order(1)
    public void testGenerarNomUsuari() {
        TreballadorEntity treballador = DadesProva.getTreballador1();
        String nomUsuari = generarNomUsuariService.generar(treballador.getNom(), treballador.getCognom1());
        assertNotEquals(treballador.getNomUsuari(), nomUsuari);
    }
}
