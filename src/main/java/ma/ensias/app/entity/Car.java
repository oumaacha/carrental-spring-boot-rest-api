package ma.ensias.app.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import ma.ensias.app.enums.CarColor;

@Entity
@Table
public class Car {
	@Id
	@SequenceGenerator(
			name = "car_sequence",
			sequenceName = "car_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "car_sequence"
	)
	private Long carId;
	private String carBrand;
	private String carModel;
	private LocalDate yearOfManufac;
	private double pricePerDay;
	private int distanceDriven;
	private int maxSpeed;
	@Enumerated(EnumType.STRING)
	private CarColor carColor;
	@ManyToOne(fetch = FetchType.EAGER) //LAZY
	@JoinColumn(name = "renter_id")
	private Renter renter;
	
	public Car() {}

	public Car(String carBrand, String carModel, LocalDate yearOfManufac, double pricePerDay, int distanceDriven,
			int maxSpeed, CarColor carColor, Renter renter) {
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.yearOfManufac = yearOfManufac;
		this.pricePerDay = pricePerDay;
		this.distanceDriven = distanceDriven;
		this.maxSpeed = maxSpeed;
		this.carColor = carColor;
		this.renter = renter;
	}

	public Car(Long carId, String carBrand, String carModel, LocalDate yearOfManufac, double pricePerDay,
			int distanceDriven, int maxSpeed, CarColor carColor, Renter renter) {
		this.carId = carId;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.yearOfManufac = yearOfManufac;
		this.pricePerDay = pricePerDay;
		this.distanceDriven = distanceDriven;
		this.maxSpeed = maxSpeed;
		this.carColor = carColor;
		this.renter = renter;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public LocalDate getYearOfManufac() {
		return yearOfManufac;
	}

	public void setYearOfManufac(LocalDate yearOfManufac) {
		this.yearOfManufac = yearOfManufac;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getDistanceDriven() {
		return distanceDriven;
	}

	public void setDistanceDriven(int distanceDriven) {
		this.distanceDriven = distanceDriven;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public CarColor getCarColor() {
		return carColor;
	}

	public void setCarColor(CarColor carColor) {
		this.carColor = carColor;
	}

	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
		this.renter = renter;
	}
}