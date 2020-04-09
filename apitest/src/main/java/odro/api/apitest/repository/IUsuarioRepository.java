package odro.api.apitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odro.api.apitest.model.CarpoolUsersEO;

public interface IUsuarioRepository extends JpaRepository<CarpoolUsersEO, Long>{

}
