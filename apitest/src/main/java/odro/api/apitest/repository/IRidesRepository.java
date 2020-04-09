/**
 * 
 */
package odro.api.apitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odro.api.apitest.model.RidesEO;

/**
 * @author wizar
 *
 */
public interface IRidesRepository extends JpaRepository<RidesEO, Long>{

}
