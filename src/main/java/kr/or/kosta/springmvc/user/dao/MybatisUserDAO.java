package kr.or.kosta.springmvc.user.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.kosta.springmvc.user.domain.Login;
import kr.or.kosta.springmvc.user.domain.User;

@Repository
public class MybatisUserDAO implements UserDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "kr.or.kosta.springmvc.user.dao.UserDAO";
	
	@Override
	public User login(Login login) throws Exception {
		return sqlSession.selectOne(namespace+".login", login);
	}

	@Override
	public void keepLogin(String uno, String sessionId, Date next) {

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("uno", uno);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);
		
		sqlSession.update(namespace+".keepLogin", paramMap);
	}

	@Override
	public User checkUserWithSessionKey(String value) {
		return sqlSession.selectOne(namespace+".checkUserWithSessionKey", value);
	}

}
