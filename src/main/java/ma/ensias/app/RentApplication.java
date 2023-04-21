package ma.ensias.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import ma.ensias.app.config.CarConfig;
import ma.ensias.app.config.RenterConfig;

@SpringBootApplication
@Import({RenterConfig.class,CarConfig.class})
public class RentApplication {
	public static void main(String[] args) {
		SpringApplication.run(RentApplication.class, args);
	}
}