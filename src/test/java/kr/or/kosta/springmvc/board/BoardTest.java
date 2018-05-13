package kr.or.kosta.springmvc.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import kr.or.kosta.springmvc.board.dao.BoardDAO;
import kr.or.kosta.springmvc.board.domain.Board;
import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.PageMaker;
import kr.or.kosta.springmvc.board.domain.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardTest {

	@Inject
	BoardDAO dao;
	Logger logger = Logger.getLogger(BoardTest.class);

	//@Test
	public void testCreate() throws Exception {

		dao.create(new Board(1, "하이", "하이루", "사종찬", null, 0, 0));
		logger.info("하이루");
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read(1));

	}

	// @Test
	public void testUpdate() throws Exception {
		dao.update(new Board(1, "하삼", "하삼루", "사종찬", null, 0, 0));

	}
	
//	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
		
	}

//	@Test
	public void testListAll() {
		List<Board> list = dao.listAll();
		for (Board board : list) {
			logger.info(board.toString());
		}
	}
	
//	@Test
	public void testListPage() throws Exception {
		int page = 1;
		
		List<Board> list = dao.listPage(page);
		
		for (Board board : list) {
			logger.info(board);
		}
	}
	
//	@Test
	public void testListCriteria() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(100);
		
		List<Board> list = dao.listCriteria(cri);
		
		for (Board board : list) {
			logger.info(board);
		}
	}
	
//	@Test
	public void testURI() throws Exception{
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				                      .path("/board/read").queryParam("bno", 12).queryParam("perPageNum", 20)
				                      .build();
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
	
//	@Test
	public void testPageMaker() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(20);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(1000);
		
		logger.info(pageMaker);
	}
	
	@Test
	public void testListSearch() throws Exception {
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("쥐");
		cri.setSearchType("t");
		
		logger.info("======================================");
		
		List<Board> list = dao.listSearch(cri);
		
		for (Board board : list) {
			logger.info(board);
		}
		
		logger.info("======================================");
		
		logger.info("COUNT: " + dao.listSearchCount(cri));
	}
}
