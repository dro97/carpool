/**
 * 
 */
package odro.api.apitest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "extra_info")
@Entity
public class ExtraInfoEO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_extra")
	private Long idExtra;
	@Column(name = "recomendations")
	private String recomendations;
	@Column(name = "descriptions")
	private String descriptions;
	@ManyToOne(cascade=CascadeType.ALL
			,fetch = FetchType.LAZY)
	 @JoinColumn(name = "extra_info_id_extra")
	  private CarpoolUsersEO users;
	
	public Long getIdExtra() {
		return idExtra;
	}

	public void setIdExtra(Long idExtra) {
		this.idExtra = idExtra;
	}

	public String getRecomendations() {
		return recomendations;
	}

	public void setRecomendations(String recomendations) {
		this.recomendations = recomendations;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}



	public CarpoolUsersEO getUsers() {
		return users;
	}

	public void setUsers(CarpoolUsersEO users) {
		this.users = users;
	}


	
}
