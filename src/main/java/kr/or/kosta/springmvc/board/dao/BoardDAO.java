package kr.or.kosta.springmvc.board.dao;

import java.util.List;

import kr.or.kosta.springmvc.board.domain.Board;
import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.SearchCriteria;

public interface BoardDAO {

	/** 게시글 생성 */
	public void create(Board board) throws Exception;
	
	/** 전체 조회 */
	public List<Board> listAll();
	
	/** 전체 조회 (페이징 처리)*/
	public List<Board> listPage(int page) throws Exception;
	
	public List<Board> listCriteria(Criteria cri) throws Exception;
	
	/** 게시글 조회 */
	public Board read(int bno) throws Exception;
	
	/** 게시글 수정 */
	public void update(Board board) throws Exception;
	
	/** 게시글 삭제 */
	public void delete(int bno) throws Exception;
	
	/** 총 게시글 수 */
	public int countPaging(Criteria cri) throws Exception;
	
	/** 검색조건에 따라 게시글 조회 */
	public List<Board> listSearch(SearchCriteria cri) throws Exception;
	
	/** 검색조건에 따라 게시글 수 조회*/
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	/** 게시글에 대한 댓글 수 증가*/
	public void updateReplyCnt(int bno, int amount) throws Exception;
	
	/** 게시글 조회 수 증가*/
	public void updateViewCnt(int bno) throws Exception;
	
	/** 파일 첨부 */
	public void addAttach(String fullName) throws Exception;
	
}
