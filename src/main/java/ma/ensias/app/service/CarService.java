package ma.ensias.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ma.ensias.app.entity.Car;
import ma.ensias.app.entity.Renter;
import ma.ensias.app.enums.CarColor;
import ma.ensias.app.repository.CarRepository;
import ma.ensias.app.repository.RenterRepository;

@Service
public class CarService {
	final private CarRepository carRepository;
	final private RenterRepository renterRepository;
	
	@Autowired
	public CarService(CarRepository carRepository, RenterRepository renterRepository) {
		this.carRepository = carRepository;
		this.renterRepository = renterRepository;
	}
	
	public List<Car> getCars() {
		return this.carRepository.findAll();
	}

	public void addCar(Car car) {
		Optional<Renter> renter = this.renterRepository.findById(car.getRenter().getRenterId());
		if(!renter.isPresent()) throw new IllegalStateException("The renter with id "+car.getRenter().getRenterId()+" does not exists");
		car.setRenter(renter.get());
		this.carRepository.save(car);
	}

	public void deleteCarById(Long carId) {
		Optional<Car> car = this.carRepository.findById(carId);
		if(!car.isPresent()) throw new IllegalStateException("The car with id "+carId+" does not exists");
		this.carRepository.deleteById(carId);
	}

	public List<Car> getCarsByBrand(String brand) {
		return this.carRepository.findCarByBrand(brand);
	}
	
	@Transactional
	public void updateCar(Long id, double pricePerDay, CarColor color) {
		Optional<Car> car = this.carRepository.findById(id);
		if(!car.isPresent()) throw new IllegalStateException("The car with id "+id+" does not exists");
		if(pricePerDay > 0) {
			if(pricePerDay != car.get().getPricePerDay()) car.get().setPricePerDay(pricePerDay);
			else throw new IllegalStateException("You entered current price");
		}else throw new IllegalStateException("The price cannot be negative");
		
		if(this.isAvailable(color)) {
			if(color != car.get().getCarColor()) car.get().setCarColor(color);
			else throw new IllegalStateException("You chose current color");
		}else throw new IllegalStateException("The color you provided is not available");
	}
	public boolean isAvailable(CarColor color) {
		for (CarColor c : CarColor.values()) {
			System.out.println(c + " color "+ color);
			if(c==color) return true;
		}
		return false;
	}
}