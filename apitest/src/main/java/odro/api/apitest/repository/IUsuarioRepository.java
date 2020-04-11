package odro.api.apitest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import odro.api.apitest.model.CarpoolUsersEO;


@Repository
public interface IUsuarioRepository extends JpaRepository<CarpoolUsersEO, Long>{

	@Query("SELECT c from CarpoolUsersEO c where c.nick =:nick")
	CarpoolUsersEO validateNick(@Param(value = "nick") String nick);
	
	@Query("SELECT c from CarpoolUsersEO c where c.email =:email")
	CarpoolUsersEO validateEmail(@Param(value = "email") String email);
	
	
	@Query("SELECT c from CarpoolUsersEO c where c.nick =:nick")
	Optional<CarpoolUsersEO> obtenerEntidad(@Param(value = "nick") String nick);
	
	
	@Query("SELECT c from  CarpoolUsersEO c where c.userCode =:userCode")
	CarpoolUsersEO getNick(@Param(value = "userCode") String userCode);
	
	
	
}
