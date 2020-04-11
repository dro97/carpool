package odro.api.apitest.model;

import java.util.List;

public class RidesResponseBean {
	
	
	private String university;
	
	private List<RidesInfoRequestBean> rides;

	public List<RidesInfoRequestBean> getRides() {
		return rides;
	}

	public void setRides(List<RidesInfoRequestBean> rides) {
		this.rides = rides;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}


	
	
	
}
