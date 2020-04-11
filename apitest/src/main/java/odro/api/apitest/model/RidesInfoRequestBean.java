package odro.api.apitest.model;

import java.util.List;

public class RidesInfoRequestBean {

	private String origin;
	
	private String destiny;
	
	private String date;
	
	private String userNo;
	
	private String ridecode;
	
	private String driver;
	
	private List<String> usersNick;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getRidecode() {
		return ridecode;
	}

	public void setRidecode(String ridecode) {
		this.ridecode = ridecode;
	}

	public List<String> getUsersNick() {
		return usersNick;
	}

	public void setUsersNick(List<String> usersNick) {
		this.usersNick = usersNick;
	}
	
	
	
	
}
