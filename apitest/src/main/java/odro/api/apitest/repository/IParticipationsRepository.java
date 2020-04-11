/**
 * 
 */
package odro.api.apitest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import odro.api.apitest.model.CarpoolUsersEO;
import odro.api.apitest.model.ParticipationsEO;
import odro.api.apitest.model.RidesEO;

/**
 * @author wizar
 *
 */
@Repository
public interface IParticipationsRepository extends JpaRepository<ParticipationsEO, Long> {
	
	@Query("SELECT c from ParticipationsEO c where c.rides =:ride")
	List<ParticipationsEO> noUsers(@Param(value = "ride")RidesEO ride);
	
	
	@Query("SELECT c from ParticipationsEO c where c.rides =:ride and c.users = :user")
	ParticipationsEO getEntity(@Param(value = "ride")RidesEO ride,@Param(value = "user")CarpoolUsersEO user);
	
	
	
	
}
