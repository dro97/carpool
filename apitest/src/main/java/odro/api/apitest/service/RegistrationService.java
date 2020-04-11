/**
 * 
 */
package odro.api.apitest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import odro.api.apitest.model.ResponseBean;
import odro.api.apitest.model.SignUpRequestBean;
import odro.api.apitest.repository.IUsuarioRepository;
import odro.api.apitest.utils.MapeoBeanesUtil;

/**
 * @author wizar
 *
 */
@Transactional
@Service
public class RegistrationService implements IRegistrationService {
	

	@Autowired
	private IUsuarioRepository userRepo;
	
	@Override
	public ResponseEntity<ResponseBean> respuestaSignUp(SignUpRequestBean request) {
		ResponseEntity<ResponseBean> response  = null;
		
		ResponseBean respuesta = new ResponseBean();
		
		ResponseBean validacion  = new ResponseBean();
		
		validacion = validateData(request);
		
		if(validacion.getCodigoError().equals("COD000")) {
			
			userRepo.save(MapeoBeanesUtil.saveUser(request));
			
			respuesta.setCodigoError("COD000");
			
			respuesta.setMsgError("Usuario guardado exitosamente");
			
			respuesta.setDescription("");
			
			
		}else {
			
			respuesta  = validacion;
		}
		
		response = new ResponseEntity<ResponseBean>(respuesta,HttpStatus.OK);
		
		return response;
	}
	
	
	private ResponseBean validateData(SignUpRequestBean request) {
		
		ResponseBean respuesta = new ResponseBean();
		
		if(userRepo.validateNick(request.getNick())!=null) {
			
			respuesta.setCodigoError("COD043");
			
			respuesta.setDescription("Pruebe con otro nick");
			
			respuesta.setMsgError("El nick ya esta en uso");
			
			
		}else {
			
			if(userRepo.validateEmail(request.getEmail())!=null) {
				
				respuesta.setCodigoError("COD044");
				
				respuesta.setDescription("Pruebe con otro correo");
				
				respuesta.setMsgError("El correo ya esta registrado");
			}else {
				
				respuesta.setCodigoError("COD000");
				
			}
			
		}
		
		return respuesta;
	}


}
