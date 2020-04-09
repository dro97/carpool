/**
 * 
 */
package odro.api.apitest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author wizar
 *
 */
@Table(name = "participations")
@Entity
public class ParticipationsEO {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idparticipations")
	private Long idParticipations;
	
	@ManyToOne
    @JoinColumn(name = "rides_idrides")
	private RidesEO rides ;
	
	@ManyToOne
    @JoinColumn(name = "carpool_users_idusers")
	private CarpoolUsersEO users;

	public Long getIdParticipations() {
		return idParticipations;
	}

	public void setIdParticipations(Long idParticipations) {
		this.idParticipations = idParticipations;
	}

	public RidesEO getRides() {
		return rides;
	}

	public void setRides(RidesEO rides) {
		this.rides = rides;
	}

	public CarpoolUsersEO getUsers() {
		return users;
	}

	public void setUsers(CarpoolUsersEO users) {
		this.users = users;
	}
	
	

}
