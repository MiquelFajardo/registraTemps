package informaticassa.cat.registra_temps;

import informaticassa.cat.registra_temps.entities.TreballadorEntity;
import informaticassa.cat.registra_temps.services.AutenticacioService;
import informaticassa.cat.registra_temps.services.GenerarNomUsuariService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@SpringBootTest(classes=RegistraTempsApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {
    @Autowired
    GenerarNomUsuariService generarNomUsuariService;
    @Autowired
    AutenticacioService autenticacioService;

    TreballadorEntity treballador = DadesProva.getTreballador1();

    @Test
    @Order(1)
    public void testGenerarNomUsuari() {
        treballador = DadesProva.getTreballador1();
        String nomUsuari = generarNomUsuariService.generar(treballador.getNom(), treballador.getCognom1());
        assertNotEquals(treballador.getNomUsuari(), nomUsuari);
    }

    @Test
    @Order(2)
    public void testAutenticar() {
        Long idAutenticat = autenticacioService.autenticar(treballador.getNomUsuari(), treballador.getContrasenya());
        assertEquals(1, idAutenticat);
        Long idNoAutenticat = autenticacioService.autenticar(treballador.getNomUsuari(), "contrasenya_incorrecta");
        assertNull(idNoAutenticat);
    }
}
