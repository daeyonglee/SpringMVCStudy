package kr.or.kosta.springmvc.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.springmvc.member.dao.MemberDAO;
import kr.or.kosta.springmvc.member.domain.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {

	@Inject
	private SqlSession sqlSession;
	
	private static Logger logger = Logger.getLogger(MemberDAOTest.class);
	
	MemberDAO dao;
	
	@Before
	public void setup() {
		dao = sqlSession.getMapper(MemberDAO.class);
	}
	
//	@Test
	public void create() {
		dao.create(new Member("kosta8", "1235", "코스타2", "kosta2@gmail.co.kr", null, null));
	}
	
//	@Test
	public void read() {
		logger.info(dao.read("kosta"));
	}
	
//	@Test
	public void update() {
		dao.update(new Member("kosta", "4444", "코스타Up", "kosta@naver.com", null, null));
	}
	
//	@Test
	public void delete() {
		dao.delete("kosta8");
	}
	
	@Test
	public void isMember() {
		Member member = dao.isMember("kosta", "4444");
		logger.info(member);
	}
}
