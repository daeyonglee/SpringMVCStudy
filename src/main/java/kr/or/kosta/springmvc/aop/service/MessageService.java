package kr.or.kosta.springmvc.aop.service;

import kr.or.kosta.springmvc.aop.domain.Message;

public interface MessageService {
	
	public void addMessage(Message message) throws Exception;
	
	public Message readMessage(String uno, int mno) throws Exception;
	
}
