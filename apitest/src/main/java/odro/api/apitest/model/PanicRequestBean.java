/**
 * 
 */
package odro.api.apitest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author wizar
 *
 */
public class PanicRequestBean {
	
	@JsonProperty("latitud")
	private String latitud;
	@JsonProperty("longitud")
	private String longitud;
	@JsonProperty("type")
	private String type;
	@JsonProperty("nick")
	private String nick;
	@JsonProperty("email")
	private String email;
	@JsonProperty("description")
	private String description;

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
