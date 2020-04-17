/**
 * 
 */
package odro.api.apitest.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import odro.api.apitest.model.AuthenticationResponse;
import odro.api.apitest.model.CarpoolUsersEO;
import odro.api.apitest.model.GeneralRideRequestBean;
import odro.api.apitest.model.ParticipationsEO;
import odro.api.apitest.model.ResponseBean;
import odro.api.apitest.model.RidesEO;
import odro.api.apitest.model.RidesInfoRequestBean;
import odro.api.apitest.model.RidesRequestBean;
import odro.api.apitest.model.RidesResponseBean;
import odro.api.apitest.model.RidesTodayResponseBean;
import odro.api.apitest.repository.IConexionRepository;
import odro.api.apitest.repository.IParticipationsRepository;
import odro.api.apitest.repository.IRidesRepository;
import odro.api.apitest.repository.IUsuarioRepository;
import odro.api.apitest.utils.ApiConstants;
import odro.api.apitest.utils.MapeoBeanesUtil;

/**
 * @author wizar
 *
 */
@Transactional
@Service
public class RidesService implements IRidesService {

	@Autowired
	private IRidesRepository ridesRepo;
	@Autowired 
	private IUsuarioRepository userRepo;
	@Autowired
	private IParticipationsRepository partRepo;
	@Autowired
	private IConexionRepository conecRepo;
	@Override
	public ResponseEntity<ResponseBean> newRide(RidesRequestBean request,HttpServletRequest data) {

		ResponseEntity<ResponseBean> response  = null;
		
		AuthenticationResponse validacionToken = new AuthenticationResponse();
		
		validacionToken = validacion(request.getDriver(),data);
		
		ResponseBean respuesta = new ResponseBean();
		if(validacionToken.getCodeError().equals(ApiConstants.COD_OK_TOKEN)) {
		
		RidesEO rideInsertado = new RidesEO();
		
		if(userRepo.getNick(request.getDriver()).getUserType().equals("2")) {
		
			rideInsertado = ridesRepo.saveAndFlush(MapeoBeanesUtil.newRide(request));
		
		respuesta.setCodigoError("COD000");
		respuesta.setMsgError("Creacion de nuevo viaje exitosa");
		
		GeneralRideRequestBean firstInsert  = new GeneralRideRequestBean();
		
		
		firstInsert.setNick(userRepo.getNick(request.getDriver()).getNick());
		firstInsert.setRideCode(request.getDriver());
		

		Optional<CarpoolUsersEO> oldEntity = userRepo.obtenerEntidad(userRepo.getNick(request.getDriver()).getNick());
		if (oldEntity.isPresent()) {
			
			
			
			
			ParticipationsEO part = new ParticipationsEO();
			
			part.setRides(rideInsertado);
			part.setUsers(oldEntity.get());
			
			
			partRepo.saveAndFlush(part);
			respuesta.setCodigoError("COD00");
			respuesta.setMsgError("Se agrego al viaje exitosamente");
			
			
		}
			
		
		}else {
			respuesta.setCodigoError("COD032");
			respuesta.setMsgError("Solo un usuario conductor puede crear un nuevo viaje!!");
			
		}
	
		}else {
			
			
			respuesta.setCodigoError(validacionToken.getCodeError());
			respuesta.setMsgError(validacionToken.getMsgError());
			
			
		}
		response = new ResponseEntity<ResponseBean>(respuesta,HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<ResponseBean> joinRide(GeneralRideRequestBean request,HttpServletRequest data) {
		
		ResponseEntity<ResponseBean> response  = null;
		
		ResponseBean respuesta = new ResponseBean();
		
		
AuthenticationResponse validacionToken = new AuthenticationResponse();
RidesEO entidadNueva = new RidesEO();
		
		validacionToken = validacion(request.getNick(),data);
		if(validacionToken.getCodeError().equals(ApiConstants.COD_OK_TOKEN)) {
		
		
		
		
		if(request.getStatus().equals("END")) {
			
			Optional<RidesEO> oldEntity2 = ridesRepo.obtenerEntidad(request.getRideCode());
			if (oldEntity2.isPresent()) {
			
				
				entidadNueva = oldEntity2.get();
				entidadNueva.setStatus("END");
				ridesRepo.saveAndFlush(entidadNueva);
				
				respuesta.setCodigoError("COD000");
				respuesta.setDescription("END");
				respuesta.setMsgError("Viaje finalizado exitosamente");
				
			}
			
		}
		else {
			if(request.getStatus().equals("START")) {
				
				Optional<RidesEO> oldEntity2 = ridesRepo.obtenerEntidad(request.getRideCode());
				if (oldEntity2.isPresent()) {
				
					
					entidadNueva = oldEntity2.get();
					entidadNueva.setStatus("START");
					ridesRepo.saveAndFlush(entidadNueva);
					respuesta.setCodigoError("COD000");
					respuesta.setDescription("START");
					respuesta.setMsgError("Viaje iniciado exitosamente");
					
				}
				
			}
			else {
				
			
			
		 Optional<CarpoolUsersEO> oldEntity = userRepo.obtenerEntidad(request.getNick());
			if (oldEntity.isPresent()) {
				
				
				Optional<RidesEO> oldEntity2 = ridesRepo.obtenerEntidad(request.getRideCode());
				if (oldEntity2.isPresent()) {
					
					
					
					
					
					if(partRepo.noUsers(oldEntity2.get()).size()>=5) {
						
						respuesta.setCodigoError("COD070");
						respuesta.setMsgError("Ya existen un total de 5 personas en el viaje");
						respuesta.setMsgError("Prueba con otro viaje!! :D");
						
					}else {
						List<ParticipationsEO> user = new ArrayList<ParticipationsEO>();
						user = partRepo.noUsers(oldEntity2.get());
						int tamaño = user.size();
						String codigo = "";
						for(int i = 0; i<tamaño;i++) {
							
							if(oldEntity.get().getId()==user.get(i).getUsers().getId()) {
								
								codigo = "CODERROR";
								 break;
								
							}
							else {
								
								continue;
							}
							
						}
						
						if(codigo.equals("CODERROR")) {
							respuesta.setCodigoError("COD056");
							respuesta.setMsgError("Ya estas registrado para ese viaje");
							
						}else {
						
						
						
							
							
					ParticipationsEO part = new ParticipationsEO();
					
					part.setRides(oldEntity2.get());
					part.setUsers(oldEntity.get());
					
					
					partRepo.saveAndFlush(part);
					respuesta.setCodigoError("COD00");
					respuesta.setMsgError("Se agrego al viaje exitosamente");
						}
					}
				}
				}
			}
		
	}
		}else {
			
			respuesta.setCodigoError(validacionToken.getCodeError());
			respuesta.setMsgError(validacionToken.getMsgError());
		}
			response = new ResponseEntity<ResponseBean>(respuesta,HttpStatus.OK);
			
			return response;
	
	
	}

	@Override
	public ResponseEntity<ResponseBean> cancelRide(GeneralRideRequestBean request,HttpServletRequest data) {
		
		ResponseEntity<ResponseBean> response  = null;
		
		ResponseBean respuesta = new ResponseBean();
		
		ParticipationsEO entidad = new ParticipationsEO();
		
		
AuthenticationResponse validacionToken = new AuthenticationResponse();
		
		validacionToken = validacion(request.getNick(),data);
		if(validacionToken.getCodeError().equals(ApiConstants.COD_OK_TOKEN)) {
		
		
		 Optional<CarpoolUsersEO> oldEntity = userRepo.obtenerEntidad(request.getNick());
			if (oldEntity.isPresent()) {
				
				
				Optional<RidesEO> oldEntity2 = ridesRepo.obtenerEntidad(request.getRideCode());
				if (oldEntity2.isPresent()) {
					
					entidad = partRepo.getEntity(oldEntity2.get(), oldEntity.get());
				
					partRepo.delete(entidad);
					
					
					respuesta.setCodigoError("COD00");
					respuesta.setMsgError("Se cancelo el viaje exitosamente");
				}
				else {
					
					respuesta.setCodigoError("COD080");
					respuesta.setMsgError("No se encontro el viaje seleccionado");
					
				}
				}else {
					
					
					respuesta.setCodigoError("COD090");
					respuesta.setMsgError("No se encontro el usuario seleccionado");
					
				}
		
		}else {
			respuesta.setCodigoError(validacionToken.getCodeError());
			respuesta.setMsgError(validacionToken.getMsgError());
		}
		
			response = new ResponseEntity<ResponseBean>(respuesta,HttpStatus.OK);
		
		return response;
	}

	@Override
	public ResponseEntity<RidesTodayResponseBean> rideInfo(RidesRequestBean request,HttpServletRequest data) {
		
		ResponseEntity<RidesTodayResponseBean> response  = null;
	
AuthenticationResponse validacionToken = new AuthenticationResponse();
RidesTodayResponseBean respuesta = new  RidesTodayResponseBean();
		
		validacionToken = validacion(request.getDriver(),data);
		if(validacionToken.getCodeError().equals(ApiConstants.COD_OK_TOKEN)) {
			Optional<String> opt;
			if(request.getDriver()!=null) {
			opt = Optional.of(request.getDriver());
			}else {
				opt =null;
			}
	List<RidesEO> listaRides = ridesRepo.rideToday(Timestamp.valueOf(obtenerFecha()+" 07:00:00"),Timestamp.valueOf(obtenerFecha()+" 22:00:00"),opt);
	
	List<RidesInfoRequestBean> listaInfo = new ArrayList<RidesInfoRequestBean>();
	
	
	
	RidesResponseBean infoRides = new RidesResponseBean();
	
	
	ResponseBean messages = new  ResponseBean();
	
	if(listaRides.isEmpty()) {
		
		messages.setCodigoError("COD056");
		messages.setMsgError("No existen viajes para hoy");
		
		respuesta.setResponse(messages);
		
	}else {
		
		for(int i = 0 ; i< listaRides.size();i++) {
			
			
			RidesInfoRequestBean temporal = new RidesInfoRequestBean();
			temporal.setDate(listaRides.get(i).getRideDate().toString());
			temporal.setDestiny(listaRides.get(i).getDestiny());
			temporal.setDriver(userRepo.getNick(listaRides.get(i).getRiderCode()).getNick());
			temporal.setOrigin(listaRides.get(i).getOrigin());
			temporal.setRidecode(listaRides.get(i).getRideCode().toString());
			
			List<ParticipationsEO>partTemporal = new ArrayList<ParticipationsEO>();
			
			List<String> usersNick  = new ArrayList<String>();
			
			Optional<RidesEO> oldEntity2 = ridesRepo.obtenerEntidad(listaRides.get(i).getRideCode());
			if (oldEntity2.isPresent()) {
				
			
				partTemporal = partRepo.noUsers(oldEntity2.get());
				
			temporal.setUserNo(String.valueOf(partTemporal.size()));
			
			for(int c = 0 ; c < partTemporal.size();c++) {
			
			CarpoolUsersEO user = 	userRepo.getOne(partTemporal.get(c).getUsers().getId());
				
				
			usersNick.add(c,user.getNick());
				
			}
			
			temporal.setUsersNick(usersNick);
			
			
		}
		
			listaInfo.add(temporal);
		
	}
		
		messages.setCodigoError("COD000");
		messages.setMsgError("Viajes existentes");
		
		infoRides.setRides(listaInfo);
		infoRides.setUniversity(request.getUniversity());
		
		
		respuesta.setResponse(messages);
		respuesta.setRidesToday(infoRides);
		
		
		
		
	}
	}else {
		
		ResponseBean respuestaBean = new ResponseBean(); 
		respuestaBean.setCodigoError(validacionToken.getCodeError());
		respuestaBean.setMsgError(validacionToken.getMsgError());
		
		respuesta.setResponse(respuestaBean);
	}
	
	response = new ResponseEntity<RidesTodayResponseBean>(respuesta,HttpStatus.OK);
	
	return response;
	
	
	}
	
	
	 
	private  String obtenerFecha() {
		Date objDate = new Date();
		/*
		 * Se pone el formato de fecha a utilizar
		 */
		String dateFormat = "yyyy-MM-dd";
		SimpleDateFormat objDF = new SimpleDateFormat(dateFormat);
		String Fecha = "";
		Fecha = objDF.format(objDate).toString();
		return Fecha;
	}
		
		
		private AuthenticationResponse validacion(String nick,HttpServletRequest data) {
			
			AuthenticationResponse authResponse = new AuthenticationResponse();
			
			final String authorizationHeader = data.getHeader("Authorization");
			
			String  jwt ="";
			if(authorizationHeader ==null) {
			
				authResponse.setCodeError("COD495");
				authResponse.setMsgError("Token inexistente");
			}else {
				jwt= authorizationHeader.substring(7);
				
				authResponse =conecRepo.getToken(nick, jwt);
			}
			
			return authResponse;
		}
		
		
	
}