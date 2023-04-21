package ma.ensias.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.ensias.app.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	@Query("SELECT c FROM Car c WHERE c.carBrand ILIKE %?1%")
	List<Car> findCarByBrand(String brand);
}