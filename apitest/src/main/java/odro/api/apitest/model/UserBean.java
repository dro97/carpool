/**
 * 
 */
package odro.api.apitest.model;

import java.util.List;

/**
 * @author wizar
 *
 */
public class UserBean {
	
	
	private String name;
	
	private String university;
	
	private String registerDate;
	
	private String recomendations;
	
	private List<String> descriptions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getRecomendations() {
		return recomendations;
	}

	public void setRecomendations(String recomendations) {
		this.recomendations = recomendations;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}
	
	

}
