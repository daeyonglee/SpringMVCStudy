package kr.or.kosta.springmvc.board.dao;

import java.util.List;

import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.Reply;

public interface ReplyDAO {

	/** 댓글 전체 조회 */
	public List<Reply> list(int bno) throws Exception;
	
	/** 댓글 생성 */
	public void create(Reply reply) throws Exception;
	
	/** 댓글 수정 */
	public void update(Reply reply) throws Exception;
	
	/** 댓글 삭제 */
	public void delete(int rno) throws Exception;
	
	/** 댓글 전체 조회 (페이징 처리)*/
	public List<Reply> listPage(int bno, Criteria cri) throws Exception;
	
	/** 댓글 수 조회*/
	public int count(int bno) throws Exception;
	
	/** 게시글 번호 조회 */
	public int getBno(int rno) throws Exception;
}
