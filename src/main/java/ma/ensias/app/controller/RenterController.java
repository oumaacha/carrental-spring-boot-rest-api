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

import ma.ensias.app.entity.Renter;
import ma.ensias.app.service.RenterService;

@RestController
@RequestMapping(path = "api/v1/renters")
public class RenterController {
	final private RenterService renterService;
	
	@Autowired
	public RenterController(RenterService renterService) {
		this.renterService = renterService;
	}

	@GetMapping
	public List<Renter> getCars() {
		return this.renterService.getRenters();
	}
	
	@GetMapping(path = "{name}")
	public List<Renter> getRentersByName(@PathVariable String name) {
		return this.renterService.getRenterByName(name);
	}
	
	@PostMapping
	public void addRenter(@RequestBody Renter renter) {
		this.renterService.addRenter(renter);
	}
	
	@DeleteMapping(path = "{renterId}")
	public void deleteRenterById(@PathVariable Long renterId) {
		this.renterService.deleteRenterById(renterId);
	}
	
	@PutMapping(path = "{renterId}")
	public void updateCar(@PathVariable("renterId") Long id, 
						  @RequestParam(required = false) String renterName,
						  @RequestParam(required = false) String renterEmail,
						  @RequestParam(required = false) String renterPhone,
						  @RequestParam(required = false) String renterCity,
						  @RequestParam(required = false) String renterAdress) {
		this.renterService.updateRenter(id,renterName,renterEmail,renterPhone,renterCity,renterAdress);
	}
}
