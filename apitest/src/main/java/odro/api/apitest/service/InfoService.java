package odro.api.apitest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import odro.api.apitest.model.ResponseBean;
import odro.api.apitest.model.SignUpRequestBean;
import odro.api.apitest.repository.IUsuarioRepository;
import odro.api.apitest.utils.MapeoBeanesUtil;

@Transactional
@Service
public class InfoService implements IInfoService{

}
