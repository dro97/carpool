/**
 * 
 */
package odro.api.apitest.service;

import org.springframework.http.ResponseEntity;

import odro.api.apitest.model.ResponseBean;
import odro.api.apitest.model.SignUpRequestBean;

/**
 * @author wizar
 *
 */
public interface IRegistrationService {

	ResponseEntity<ResponseBean> respuestaSignUp(SignUpRequestBean request);
	
}
