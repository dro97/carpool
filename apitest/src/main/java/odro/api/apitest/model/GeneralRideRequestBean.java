/**
 * 
 */
package odro.api.apitest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author wizar
 *
 */
public class GeneralRideRequestBean {

	@JsonProperty("rideCode")
	private String rideCode;
	@JsonProperty("nick")
	private String nick;
	@JsonProperty("time")
	private String time;
	@JsonProperty("status")
	private String status;


	public String getRideCode() {
		return rideCode;
	}

	public void setRideCode(String rideCode) {
		this.rideCode = rideCode;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
