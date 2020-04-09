package odro.api.apitest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.implementation.Implementation.Context.ExtractableView;
import odro.api.apitest.model.CarpoolUsersEO;
import odro.api.apitest.model.ExtraInfoEO;
import odro.api.apitest.model.ParticipationsEO;
import odro.api.apitest.model.RequestApiBean;
import odro.api.apitest.model.ResponseApiBean;
import odro.api.apitest.model.RidesEO;
import odro.api.apitest.repository.IExtraRepository;
import odro.api.apitest.repository.IParticipationsRepository;
import odro.api.apitest.repository.IRidesRepository;
import odro.api.apitest.repository.IUsuarioRepository;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private IUsuarioRepository usuarioRepo;
	@Autowired
	private IExtraRepository extrarepo;
	@Autowired
	private IRidesRepository ridesRepo;
	@Autowired
	private IParticipationsRepository partRepo;
	
	
	 @PostMapping("/blog")
	    public ResponseApiBean create(@RequestBody RequestApiBean body){
		 
	
	
		 return null;
	      
	    }

}
