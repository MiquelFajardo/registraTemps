package informaticassa.cat.registra_temps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Setter;
import org.springframework.context.ApplicationContext;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

public class MainFXApp extends Application {
    @Setter
    private static ApplicationContext springContext;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/informaticassa/cat/registra_temps/views/autenticacio.fxml"));
        loader.setControllerFactory(springContext::getBean); // Usa els beans de Spring per al controlador

        Parent root = loader.load();

        primaryStage.setTitle("Registra Temps");
        primaryStage.setScene(new Scene(root, 600, 400));

        primaryStage.setOnCloseRequest(windowEvent -> {
            System.exit(0);
        });

        primaryStage.show();
    }
}
