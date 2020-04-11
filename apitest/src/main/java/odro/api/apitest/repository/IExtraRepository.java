/**
 * 
 */
package odro.api.apitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import odro.api.apitest.model.ExtraInfoEO;

/**
 * @author wizar
 *
 */
@Repository
public interface IExtraRepository extends JpaRepository<ExtraInfoEO, Long> {

}
