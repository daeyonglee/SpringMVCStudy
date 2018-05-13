package kr.or.kosta.springmvc.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.kosta.springmvc.board.domain.Board;
import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.SearchCriteria;

@Repository
public class MybatisBoardDAO implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "kr.or.kosta.springmvc.board.MybatisBoardDAO";

	@Override
	public void create(Board board) {
		sqlSession.insert(namespace+".create",board);
		
	}

	@Override
	public List<Board> listAll() {
		return sqlSession.selectList(namespace+".listAll");
	}
	
	@Override
	public List<Board> listPage(int page) throws Exception {
		return sqlSession.selectList(namespace+".listPage", page);
	}
	
	@Override
	public List<Board> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(namespace+".listCriteria", cri);
	}

	@Override
	public Board read(int bno) {
		return sqlSession.selectOne(namespace+".read",bno);
	}

	@Override
	public void update(Board board) {
		
		sqlSession.update(namespace+".update",board);
		
	}

	@Override
	public void delete(int bno) {
		sqlSession.delete(namespace+".delete",bno);
		
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(namespace+".countPaging", cri);
	}

	@Override
	public List<Board> listSearch(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace+".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace+".listSearchCount", cri);
	}

	@Override
	public void updateReplyCnt(int bno, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("bno", bno);
		paramMap.put("amount", amount);
		
		sqlSession.update(namespace+".updateReplyCnt", paramMap);
	}

	@Override
	public void updateViewCnt(int bno) throws Exception {
		sqlSession.update(namespace+".updateViewCnt", bno);
	}

	@Override
	public void addAttach(String fullName) throws Exception {
		sqlSession.insert(namespace+".addAttach", fullName);
	}
}
