/**
 * 
 */
package odro.api.apitest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author wizar
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequestBean {
	@JsonProperty("nick")
	private String nick ;
	@JsonProperty("name")
	private String name;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("password")
	private String phone;
	@JsonProperty("email")
	private String email;
	@JsonProperty("university")
	private String university;
	@JsonProperty("userType")
	private String userType;
	@JsonProperty("passw")
	private String password;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
