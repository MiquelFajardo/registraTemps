package informaticassa.cat.registra_temps.controller;

import informaticassa.cat.registra_temps.services.AutenticacioService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@Component
public class AutenticacioController {
    @Autowired
    AutenticacioService autenticacioService;

    @FXML
    private TextField usuariField;
    @FXML
    private PasswordField contrasenyaField;
    @FXML
    private TextField nifField;

    String nif;
    String usuari;
    String contrasenya;

    @FXML
    public void fitxar() {
        nif = nifField.getText();
        if (campsBuitsFitxatge()) {
            missatgeError("Camps buits", "El NIF no pots estar buit.");
        } else {
            System.out.println("FITXAR");
            netejarCampsFitxatge();
        }
    }

    @FXML
    public void validarLogin() {
        usuari = usuariField.getText();
        contrasenya = contrasenyaField.getText();

        if (campsBuitsAutenticacio()) {
            missatgeError("Camps buits", "Usuari o contrasenya no pot estar buit.");
        } else {
            autenticarUsuari();
            netejarCampsAutenticacio();
        }
    }

    /**  Fitxatge */
    private boolean campsBuitsFitxatge() {
        return (nif == null || nif.trim().isEmpty());
    }

    private boolean campsBuitsAutenticacio() {
        return ((usuari == null || usuari.trim().isEmpty()) || (contrasenya == null || contrasenya.trim().isEmpty()));
    }
     private void netejarCampsFitxatge() {
        nifField.clear();
        nif = null;
     }


    /** Autenticació */
    private void autenticarUsuari() {
        Long id = autenticacioService.autenticar(usuari, contrasenya);
        if (id != null) {
            System.out.println("DINS");
        } else {
            missatgeError("Error autenticació", "Usuari o contrasenya incorrecta.");
        }
    }

    private void netejarCampsAutenticacio() {
        usuariField.clear();
        contrasenyaField.clear();
        usuari = null;
        contrasenya = null;
    }

    /** Funcions comunes */
    private void missatgeError(String titol, String missatge) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titol);
        alert.setHeaderText(null);
        alert.setContentText(missatge);
        alert.showAndWait();
    }

}
