package kr.or.kosta.springmvc.user.service;

import java.util.Date;

import kr.or.kosta.springmvc.user.domain.Login;
import kr.or.kosta.springmvc.user.domain.User;

public interface UserService {
	
	public User login(Login login) throws Exception;
	public void keepLogin(String uno, String sessionId, Date next) throws Exception;
	public User checkLoginBefore(String value);
}
