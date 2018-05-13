package kr.or.kosta.springmvc.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.Reply;

@Repository
public class MybatisReplyDAO implements ReplyDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "kr.or.kosta.springmvc.board.MybatisReplyDAO";
	
	@Override
	public List<Reply> list(int bno) throws Exception {
		return sqlSession.selectList(NAMESPACE+".list", bno);
	}

	@Override
	public void create(Reply reply) throws Exception {
		sqlSession.insert(NAMESPACE+".create", reply);
	}

	@Override
	public void update(Reply reply) throws Exception {
		sqlSession.update(NAMESPACE+".update", reply);
	}

	@Override
	public void delete(int rno) throws Exception {
		sqlSession.delete(NAMESPACE+".delete", rno);
	}

	@Override
	public List<Reply> listPage(int bno, Criteria cri) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		
		return sqlSession.selectList(NAMESPACE+".listPage", paramMap);
	}

	@Override
	public int count(int bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".count", bno);
	}

	@Override
	public int getBno(int rno) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getBno", rno);
	}
}
