package ma.ensias.app.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ma.ensias.app.entity.Renter;
import ma.ensias.app.repository.RenterRepository;

@Configuration
public class RenterConfig {
	
	@Autowired
	final private RenterRepository renterRepository;
	
	public RenterConfig(RenterRepository renterRepository) {
		this.renterRepository = renterRepository;
	}
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return args->{
			System.out.println("-------------Initializing renter data...");
			Renter renter1 = new Renter(1L,"Oumaacha","oum@gmail.com","06666","Kech","daoui 2");
			Renter renter2 = new Renter(2L,"tattar","oum@gmail.com","06666","Kech","daoui 2");
			Renter renter3 = new Renter(3L,"tassa","oum@gmail.com","06666","Kech","daoui 2");
			Renter renter4 = new Renter(4L,"naim","oum@gmail.com","06666","Kech","daoui 2");
			renterRepository.saveAll(
				List.of(renter1,renter2,renter3,renter4)
			);
		};
	}
}