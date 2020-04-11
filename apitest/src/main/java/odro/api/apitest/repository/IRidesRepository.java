/**
 * 
 */
package odro.api.apitest.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import odro.api.apitest.model.RidesEO;

/**
 * @author wizar
 *
 */
public interface IRidesRepository extends JpaRepository<RidesEO, Long>{

	@Query("SELECT c from RidesEO c where c.rideCode =:rideCode ")
	Optional<RidesEO> obtenerEntidad(@Param(value = "rideCode") String rideCode);
	
	
	@Query("Select c from RidesEO c where c.status ='CREADO' and c.rideDate BETWEEN :startDate AND :endDate ")
	List<RidesEO> rideToday(@Param(value = "startDate")Timestamp startDate,@Param(value = "endDate")Timestamp endDate);
	
	
}
