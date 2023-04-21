package ma.ensias.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.ensias.app.entity.Car;
import ma.ensias.app.enums.CarColor;
import ma.ensias.app.service.CarService;

@RestController
@RequestMapping(path="api/v1/cars")
public class CarController {
	final private CarService carService;
	
	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping
	public List<Car> getCars() {
		return this.carService.getCars();
	}
	
	@GetMapping(path = "{brand}")
	public List<Car> getCarsByBrand(@PathVariable String brand) {
		return this.carService.getCarsByBrand(brand);
	}
	
	public List<Car> getCarsByCity(String brand) {
		return null;
	}
	
	@PostMapping
	public void addCar(@RequestBody Car car) {
		this.carService.addCar(car);
	}
	
	@DeleteMapping(path = "{carId}")
	public void deleteCarById(@PathVariable Long carId) {
		this.carService.deleteCarById(carId);
	}
	
	@PutMapping(path = "{carId}")
	public void updateCar(@PathVariable("carId") Long id, 
						  @RequestParam(required = false) double pricePerDay, 
						  @RequestParam(required = false) CarColor color) {
		this.carService.updateCar(id,pricePerDay,color);
	}
}