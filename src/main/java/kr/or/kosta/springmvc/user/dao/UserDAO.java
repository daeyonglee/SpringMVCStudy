package kr.or.kosta.springmvc.user.dao;

import java.util.Date;

import kr.or.kosta.springmvc.user.domain.Login;
import kr.or.kosta.springmvc.user.domain.User;

public interface UserDAO {

	public User login(Login login) throws Exception;
	
	public void keepLogin(String uno, String sessionId, Date next);
	
	public User checkUserWithSessionKey(String value);
	
}
