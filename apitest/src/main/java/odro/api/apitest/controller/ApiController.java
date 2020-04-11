package odro.api.apitest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import odro.api.apitest.model.GeneralRideRequestBean;
import odro.api.apitest.model.ResponseBean;
import odro.api.apitest.model.RidesRequestBean;
import odro.api.apitest.model.RidesTodayResponseBean;
import odro.api.apitest.model.SignUpRequestBean;
import odro.api.apitest.service.IRegistrationService;
import odro.api.apitest.service.IRidesService;


@RestController
@RequestMapping("/carpool")
public class ApiController {

	@Autowired
	private IRegistrationService register;
	@Autowired
	private IRidesService rides;
	
	
	@RequestMapping(path = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseBean> signUP(@Valid @RequestBody SignUpRequestBean datosIn) {
		
		/*
		 * se regresa la respuesta
		 */
		return (register.respuestaSignUp(datosIn));
		
		
	}
	
	
	@RequestMapping(path = "/newRide", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseBean> newRide(@Valid @RequestBody RidesRequestBean datosIn) {
		
		/*
		 * se regresa la respuesta
		 */
		return (rides.newRide(datosIn));
		
		
	}
	
	@RequestMapping(path = "/ride_operation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseBean> joinRide(@Valid @RequestBody GeneralRideRequestBean datosIn) {
		
		/*
		 * se regresa la respuesta
		 */
		return (rides.joinRide(datosIn));
		
		
	}
	
	@RequestMapping(path = "/ride_info", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RidesTodayResponseBean> ridesInfo(@Valid @RequestBody RidesRequestBean datosIn){
		
		return (rides.rideInfo(datosIn));
	}
	
	
}
