package informaticassa.cat.registra_temps;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@SpringBootApplication
public class RegistraTempsApplication {
		public static void main(String[] args) {
			// Inicialitza Spring Boot
			ConfigurableApplicationContext context = new SpringApplicationBuilder(RegistraTempsApplication.class).run(args);

			// Inicia JavaFX
			MainFXApp.setSpringContext(context);
			Application.launch(MainFXApp.class, args);
	}
}
