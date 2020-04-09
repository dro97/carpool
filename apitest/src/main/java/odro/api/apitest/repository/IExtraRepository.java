/**
 * 
 */
package odro.api.apitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odro.api.apitest.model.ExtraInfoEO;

/**
 * @author wizar
 *
 */
public interface IExtraRepository extends JpaRepository<ExtraInfoEO, Long> {

}
