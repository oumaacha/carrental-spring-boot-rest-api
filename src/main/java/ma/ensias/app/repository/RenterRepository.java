package ma.ensias.app.repository;

import ma.ensias.app.entity.Renter;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Configuration
public interface RenterRepository extends JpaRepository<Renter, Long>{
	@Query("SELECT r FROM Renter r WHERE r.renterName LIKE %?1%")
	List<Renter> findRenderByName(String name);
}