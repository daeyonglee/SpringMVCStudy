package kr.or.kosta.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.junit.Test;

public class OracleConnectionTest {

	private final static String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER   = "hr";
	private static final String PASSWD = "1234";
	
	private static Logger logger = Logger.getLogger(OracleConnectionTest.class);
	
	@Test
	public void test() throws ClassNotFoundException {
		
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWD)) {
			logger.info("접속 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
