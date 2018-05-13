package kr.or.kosta.springmvc.board.service;

import java.util.List;

import kr.or.kosta.springmvc.board.domain.Board;
import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.SearchCriteria;

public interface BoardService {

	/** 게시글 등록 */
	public void create(Board board) throws Exception;
	
	/** 게시글 조회 */
	public Board read(int bno) throws Exception;
	
	/** 게시글 수정*/
	public void update(Board board) throws Exception;
	
	/** 게시글 삭제*/
	public void delete(int bno) throws Exception;
	
	/** 게시글 전체 조회*/
	public List<Board> listAll() throws Exception;
	
	/** 게시글 전체 조회(페이징처리)*/
	public List<Board> listPage(int page) throws Exception;
	
	/** 게시글 전체 조회(페이징처리)*/
	public List<Board> listCriteria(Criteria cri) throws Exception;
	
	/** 총 게시글 수 조회*/
	public int listCountCriteria(Criteria cri) throws Exception;
	
	/** 검색조건에 따른 게시글 조회 */
	public List<Board> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	/** 검색조건에 따른 게시글 수 조회*/
	public int listSearchCount(SearchCriteria cri) throws Exception;

}