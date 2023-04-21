package ma.ensias.app.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ma.ensias.app.entity.Renter;
import ma.ensias.app.repository.RenterRepository;

@Service
public class RenterService {
	final private RenterRepository renterRepository;
	
	@Autowired
	public RenterService(RenterRepository renterRepository) {
		this.renterRepository = renterRepository;
	}
	
	public List<Renter> getRenters() {
		return this.renterRepository.findAll();
	}

	public void addRenter(Renter renter) {
		this.renterRepository.save(renter);
	}

	public void deleteRenterById(Long renterId) {
		Optional<Renter> renter = this.renterRepository.findById(renterId);
		if(!renter.isPresent()) throw new IllegalStateException("The renter with id "+renterId+" does not exists");
		this.renterRepository.deleteById(renterId);
	}

	public List<Renter> getRenterByName(String name) {
		return this.renterRepository.findRenderByName(name);
	}
	    
	@Transactional
	public void updateRenter(Long id, String renterName, String renterEmail, String renterPhone, String renterCity, String renterAdress) {
		Optional<Renter> renter = this.renterRepository.findById(id);
		if(!renter.isPresent()) throw new IllegalStateException("The renter with id "+id+" does not exists");
		if(renterName != null && renterName.length()>0 && !Objects.equals(renter.get().getRenterName(), renterName)) {
			renter.get().setRenterName(renterName);
		}
		if(renterEmail != null && renterEmail.length()>0 && !Objects.equals(renter.get().getRenterEmail(), renterEmail)) {
			renter.get().setRenterEmail(renterEmail);
		}
		if(renterPhone != null && renterPhone.length()>0 && !Objects.equals(renter.get().getRenterPhone(), renterPhone)) {
			renter.get().setRenterPhone(renterPhone);
		}
		if(renterCity != null && renterCity.length()>0 && !Objects.equals(renter.get().getRenterCity(), renterCity)) {
			renter.get().setRenterCity(renterCity);
		}
		if(renterAdress != null && renterAdress.length()>0 && !Objects.equals(renter.get().getRenterAdress(), renterAdress)) {
			renter.get().setRenterAdress(renterAdress);
		}
	}
}
