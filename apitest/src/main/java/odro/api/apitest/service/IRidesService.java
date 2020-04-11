/**
 * 
 */
package odro.api.apitest.service;

import org.springframework.http.ResponseEntity;

import odro.api.apitest.model.GeneralRideRequestBean;
import odro.api.apitest.model.ResponseBean;
import odro.api.apitest.model.RidesRequestBean;
import odro.api.apitest.model.RidesTodayResponseBean;

/**
 * @author wizar
 *
 */
public interface IRidesService {

	ResponseEntity<ResponseBean> newRide(RidesRequestBean request);
	
	ResponseEntity<ResponseBean> joinRide(GeneralRideRequestBean request);
	
	ResponseEntity<ResponseBean> cancelRide(GeneralRideRequestBean request);
	
	ResponseEntity<RidesTodayResponseBean> rideInfo(RidesRequestBean request);
	
}
