package odro.api.apitest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import odro.api.apitest.model.GeneralRideRequestBean;
import odro.api.apitest.model.LoginRequestBean;
import odro.api.apitest.model.LoginResponseBean;
import odro.api.apitest.model.ResponseBean;
import odro.api.apitest.model.RidesRequestBean;
import odro.api.apitest.model.RidesTodayResponseBean;
import odro.api.apitest.model.SignUpRequestBean;
import odro.api.apitest.service.ILoginService;
import odro.api.apitest.service.IRegistrationService;
import odro.api.apitest.service.IRidesService;
import odro.api.apitest.utils.EncryptionUtil;


@RestController
@RequestMapping("/carpool")
public class ApiController {

	@Autowired
	private IRegistrationService register;
	@Autowired
	private IRidesService ridesService;
	@Autowired
	private ILoginService loginService;
	
	
	@RequestMapping(path = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseBean> signUP(@Valid @RequestBody SignUpRequestBean datosIn) {
					
		/*
		 * se regresa la respuesta
		 */
		return (register.respuestaSignUp(datosIn));
		
		
	}
	
	
	@RequestMapping(path = "/newRide", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseBean> newRide(@Valid @RequestBody RidesRequestBean datosIn,final @Context HttpServletRequest request) {
		
		/*
		 * se regresa la respuesta
		 */
		return (ridesService.newRide(datosIn,request));
		
		
	}
	
	@RequestMapping(path = "/ride_operation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseBean> joinRide(@Valid @RequestBody GeneralRideRequestBean datosIn,final @Context HttpServletRequest request) {
		
		/*
		 * se regresa la respuesta
		 */
		return (ridesService.joinRide(datosIn,request));
		
	}
	
	@RequestMapping(path = "/ride_info", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RidesTodayResponseBean> ridesInfo(@Valid @RequestBody RidesRequestBean datosIn,final @Context HttpServletRequest request){
		
		return (ridesService.rideInfo(datosIn,request));
	}
	
	
	@RequestMapping(path = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<LoginResponseBean> login(@Valid @RequestBody LoginRequestBean data,final @Context HttpServletRequest request) {
			
		/*
		 * se regresa la respuesta
		 */
 		return (loginService.login(data, request));
		
		
	}
	
	
	
	
	
}
