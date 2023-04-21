package ma.ensias.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Renter {
	@Id
	@SequenceGenerator(
			name="renter_sequence",
			sequenceName="renter_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "renter_sequence"
	)
    private Long renterId;
    private String renterName;
    private String renterEmail;
    private String renterPhone;
    private String renterCity;
    private String renterAdress;
    @OneToMany(mappedBy = "renter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;
    
	public Renter() {}

	public Renter(String renterName, String renterEmail, String renterPhone, String renterCity, String renterAdress) {
		this.renterName = renterName;
		this.renterEmail = renterEmail;
		this.renterPhone = renterPhone;
		this.renterCity = renterCity;
		this.renterAdress = renterAdress;
	}

	public Renter(Long renterId, String renterName, String renterEmail, String renterPhone, String renterCity,
			String renterAdress) {
		this.renterId = renterId;
		this.renterName = renterName;
		this.renterEmail = renterEmail;
		this.renterPhone = renterPhone;
		this.renterCity = renterCity;
		this.renterAdress = renterAdress;
	}

	public Long getRenterId() {
		return renterId;
	}

	public void setRenterId(Long renterId) {
		this.renterId = renterId;
	}

	public String getRenterName() {
		return renterName;
	}

	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}

	public String getRenterEmail() {
		return renterEmail;
	}

	public void setRenterEmail(String renterEmail) {
		this.renterEmail = renterEmail;
	}

	public String getRenterPhone() {
		return renterPhone;
	}

	public void setRenterPhone(String renterPhone) {
		this.renterPhone = renterPhone;
	}

	public String getRenterCity() {
		return renterCity;
	}

	public void setRenterCity(String renterCity) {
		this.renterCity = renterCity;
	}

	public String getRenterAdress() {
		return renterAdress;
	}

	public void setRenterAdress(String renterAdress) {
		this.renterAdress = renterAdress;
	}
}