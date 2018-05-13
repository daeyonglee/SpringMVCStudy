package kr.or.kosta.springmvc.aop.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.kosta.springmvc.aop.dao.MessageDAO;
import kr.or.kosta.springmvc.aop.dao.PointDAO;
import kr.or.kosta.springmvc.aop.domain.Message;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Inject
	private MessageDAO messageDAO;
	
	@Inject
	private PointDAO pointDAO;
	
	@Transactional
	@Override
	public void addMessage(Message message) throws Exception {
		messageDAO.create(message);
		pointDAO.updatePoint(message.getSender(), 10);
	}

	@Override
	public Message readMessage(String uno, int mno) throws Exception {
		
		messageDAO.updateState(mno);
		pointDAO.updatePoint(uno, 5);
		
		return messageDAO.readMessage(mno);
	}

}
