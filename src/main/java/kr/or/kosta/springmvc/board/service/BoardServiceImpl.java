package kr.or.kosta.springmvc.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.kosta.springmvc.board.dao.BoardDAO;
import kr.or.kosta.springmvc.board.domain.Board;
import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	@Transactional
	@Override
	public void create(Board board) throws Exception {
		dao.create(board);
		
		String[] files = board.getFiles();
		
		if (files == null) return;
		
		for (String fileName : files) {
			dao.addAttach(fileName);
		}
		
	}

	@Transactional
	@Override
	public Board read(int bno) throws Exception {
		dao.updateViewCnt(bno);
		return dao.read(bno);
	}

	@Override
	public void update(Board board) throws Exception {
		dao.update(board);
	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<Board> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<Board> listPage(int page) throws Exception {
		return dao.listPage(page);
	}

	@Override
	public List<Board> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Board> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
}
