/**
 * 
 */
package odro.api.apitest.service;

import javax.servlet.http.HttpServletRequest;

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

	ResponseEntity<ResponseBean> newRide(RidesRequestBean request,HttpServletRequest data);
	
	ResponseEntity<ResponseBean> joinRide(GeneralRideRequestBean request,HttpServletRequest data);
	
	ResponseEntity<ResponseBean> cancelRide(GeneralRideRequestBean request,HttpServletRequest data);
	
	ResponseEntity<RidesTodayResponseBean> rideInfo(RidesRequestBean request,HttpServletRequest data);
	
}
