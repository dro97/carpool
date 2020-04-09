/**
 * 
 */
package odro.api.apitest.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author wizar
 *
 */
@Table(name = "rides")
@Entity
public class RidesEO {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idrides")
	private Long idRides;
	@Column(name = "origin")
	private String origin;
	@Column(name = "destiny")
	private String destiny;
	@Column(name = "description")
	private String description;
	@Column(name = "ride_date")
	private Timestamp rideDate;
	
	@OneToMany(mappedBy = "users")
	 private List<ParticipationsEO>  participations;

	public Long getIdRides() {
		return idRides;
	}

	public void setIdRides(Long idRides) {
		this.idRides = idRides;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ParticipationsEO> getParticipations() {
		return participations;
	}

	public void setParticipations(List<ParticipationsEO> participations) {
		this.participations = participations;
	}

	public Timestamp getRideDate() {
		return rideDate;
	}

	public void setRideDate(Timestamp rideDate) {
		this.rideDate = rideDate;
	}




	
	
	
}
