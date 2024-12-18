package informaticassa.cat.registra_temps.services;

import informaticassa.cat.registra_temps.repositories.TreballadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Service
public class GenerarNomUsuariService {
    @Autowired
    private TreballadorRepository treballadorRepository;

    public String generar(String nom, String cognom1) {
        int sequencia = 1;
        char inicialNom = Character.toLowerCase(nom.trim().charAt(0));
        String nomUsuari;

        do {
            nomUsuari = inicialNom + cognom1.trim().toLowerCase() + sequencia;
            sequencia++;
        } while(existeixNomUsuari(nomUsuari));

        return nomUsuari;
    }

    public boolean existeixNomUsuari(String nomUsuari) {
        return treballadorRepository.existsByNomUsuari(nomUsuari);
    }
}
