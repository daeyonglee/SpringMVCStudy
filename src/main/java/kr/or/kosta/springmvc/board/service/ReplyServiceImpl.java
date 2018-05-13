package kr.or.kosta.springmvc.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.kosta.springmvc.board.dao.BoardDAO;
import kr.or.kosta.springmvc.board.dao.ReplyDAO;
import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.Reply;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyDAO replyDAO;
	
	@Inject
	private BoardDAO boardDAO;
	
	@Transactional
	@Override
	public void addReply(Reply reply) throws Exception {
		replyDAO.create(reply);
		boardDAO.updateReplyCnt(reply.getBno(), 1);
	}

	@Override
	public List<Reply> listReply(int bno) throws Exception {
		return replyDAO.list(bno);
	}

	@Override
	public void updateReply(Reply reply) throws Exception {
		replyDAO.update(reply);
	}

	@Transactional
	@Override
	public void deleteReply(int rno) throws Exception {
		int bno = replyDAO.getBno(rno);
		replyDAO.delete(rno);
		boardDAO.updateReplyCnt(bno, -1);
	}

	@Override
	public List<Reply> listReplyPage(int bno, Criteria cri) throws Exception {
		return replyDAO.listPage(bno, cri);
	}

	@Override
	public int count(int bno) throws Exception {
		return replyDAO.count(bno);
	}
}
