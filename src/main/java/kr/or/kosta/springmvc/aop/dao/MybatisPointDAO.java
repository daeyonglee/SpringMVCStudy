package kr.or.kosta.springmvc.aop.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisPointDAO implements PointDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void updatePoint(String uno, int point) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		map.put("uno", uno);
		map.put("point", point);
		
		sqlSession.update("kr.or.kosta.springmvc.aop.dao.PointDAO.updatePoint", map);
	}

}
