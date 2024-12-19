package informaticassa.cat.registra_temps.services;

import informaticassa.cat.registra_temps.repositories.TreballadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Service
public class AutenticacioService {
    @Autowired
    private TreballadorRepository treballadorRepository;

    public static String ERROR_USUARI = "Usuari o contrasenya incorrecta";
    public static String USUARI_AUTENTICAT = "Usuari autenticat";

    public Long autenticar(String nomUsuari, String contrasenya) {
        return treballadorRepository.autenticar(nomUsuari, contrasenya);
    }
}
