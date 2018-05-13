package kr.or.kosta.springmvc.user.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.springmvc.user.dao.UserDAO;
import kr.or.kosta.springmvc.user.domain.Login;
import kr.or.kosta.springmvc.user.domain.User;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO dao;
	
	@Override
	public User login(Login login) throws Exception {
		return dao.login(login);
	}

	@Override
	public void keepLogin(String uno, String sessionId, Date next) throws Exception {
		dao.keepLogin(uno, sessionId, next);
	}

	@Override
	public User checkLoginBefore(String value) {
		return dao.checkUserWithSessionKey(value);
	}

}
