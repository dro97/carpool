/**
 * 
 */
package odro.api.apitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odro.api.apitest.model.ParticipationsEO;

/**
 * @author wizar
 *
 */
public interface IParticipationsRepository extends JpaRepository<ParticipationsEO, Long> {

	
	
}
