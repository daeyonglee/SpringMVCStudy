package kr.or.kosta.springmvc.aop.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.kosta.springmvc.aop.domain.Message;

@Repository
public class MybatisMessageDAO implements MessageDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void create(Message message) throws Exception {
		sqlSession.insert("kr.or.kosta.springmvc.aop.dao.MessageDAO.create", message);
	}

	@Override
	public Message readMessage(int mno) throws Exception {
		return sqlSession.selectOne("kr.or.kosta.springmvc.aop.dao.MessageDAO.readMessage", mno);
	}

	@Override
	public void updateState(int mno) throws Exception {
		sqlSession.update("kr.or.kosta.springmvc.aop.dao.MessageDAO.updateState", mno);
	}
}
