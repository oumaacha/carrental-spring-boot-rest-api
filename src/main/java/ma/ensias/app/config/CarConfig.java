package ma.ensias.app.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ma.ensias.app.entity.Car;
import ma.ensias.app.entity.Renter;
import ma.ensias.app.enums.CarColor;
import ma.ensias.app.repository.CarRepository;

@Configuration
public class CarConfig {
	@Autowired
	final private CarRepository carRepository;
	
	public CarConfig(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args->{
			System.out.println("-------------Initializing car data...");
			Renter renter1 = new Renter(1L,"Oumaacha","oum@gmail.com","06666","Kech","daoui 2");
			Car Tesla1 = new Car(1L,"Tesla","Model X",LocalDate.of(2016,1,1),600.0,3200,250,CarColor.WHITE,renter1);
			Car Tesla2 = new Car(2L,"Tesla","Model X",LocalDate.of(2016,1,1),600.0,3200,250,CarColor.BLACK,renter1);
			Car Tesla3 = new Car(3L,"Tesla","Model X",LocalDate.of(2016,1,1),600.0,3200,250,CarColor.BLUE,renter1);
			Car Tesla4 = new Car(4L,"Tesla","Model X",LocalDate.of(2016,1,1),600.0,3200,250,CarColor.GRAY,renter1);
			carRepository.saveAll(
				List.of(Tesla1,Tesla2,Tesla3,Tesla4)
			);
		};
	}
}