package kr.or.kosta.springmvc.board.service;

import java.util.List;

import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.Reply;

public interface ReplyService {

	/** 댓글 추가 */
	public void addReply(Reply reply) throws Exception;
	
	/** 댓글 목록 조회 */
	public List<Reply> listReply(int bno) throws Exception;
	
	/** 댓글 수정 */
	public void updateReply(Reply reply) throws Exception;
	
	/** 댓글 삭제 */
	public void deleteReply(int rno) throws Exception;
	
	/** 댓글 목록 조회 (페이징처리)*/
	public List<Reply> listReplyPage(int bno, Criteria cri) throws Exception;
	
	/** 댓글 수 조회*/
	public int count(int bno) throws Exception;
}
