/**
 * 
 */
package odro.api.apitest.utils;

import java.sql.Timestamp;
import java.util.Random;
import java.util.UUID;

import odro.api.apitest.model.CarpoolUsersEO;
import odro.api.apitest.model.RidesEO;
import odro.api.apitest.model.RidesRequestBean;
import odro.api.apitest.model.SignUpRequestBean;

/**
 * @author wizar
 *
 */
public  class MapeoBeanesUtil {
	
	public static CarpoolUsersEO saveUser(SignUpRequestBean data) {
		CarpoolUsersEO response = new CarpoolUsersEO();
		
		response.setEmail(data.getEmail());
		response.setLastname(data.getLastname());
		response.setName(data.getName());
		response.setNick(data.getNick());		
		response.setPassword(EncryptionUtil.decrypt(data.getPassword()));
		response.setPhone(data.getPhone());
		response.setUniversity(data.getUniversity());
		response.setUserType(data.getUserType());
		response.setUserCode(userCode());
		
		
		
		return response;
		
		
	}
	
	private static String userCode() {
		
		
		 int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 15;
		    Random random = new Random();
		 
		    String generatedString = random.ints(leftLimit, rightLimit + 1)
		      .limit(targetStringLength)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
		 
		   return generatedString.toUpperCase();
		
	}
	
	
	public static RidesEO newRide(RidesRequestBean request) {
		
		RidesEO entidad = new RidesEO();
		
		
		entidad.setDescription(request.getDescription());
		entidad.setDestiny(request.getDestiny());
		entidad.setOrigin(request.getOrigin());
		entidad.setRiderCode(request.getDriver());
		entidad.setRideDate(Timestamp.valueOf(request.getDate()));
		
		entidad.setRideCode(UUID.randomUUID().toString());
		
		entidad.setStatus("CREADO");
		
		return entidad;
		
	}
	
	


}
