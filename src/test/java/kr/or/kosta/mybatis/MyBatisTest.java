package kr.or.kosta.mybatis;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest {

	private static Logger logger = Logger.getLogger(MyBatisTest.class);
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		logger.info(sqlFactory);
	}
	
	@Test
	public void testSession() {
		try (SqlSession session = sqlFactory.openSession()){
			logger.info(session);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
