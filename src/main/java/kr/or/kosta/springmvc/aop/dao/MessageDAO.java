package kr.or.kosta.springmvc.aop.dao;

import kr.or.kosta.springmvc.aop.domain.Message;

public interface MessageDAO {

	public void create(Message message) throws Exception;
	
	public Message readMessage(int mno) throws Exception;
	
	public void updateState(int mno) throws Exception;
	
}
