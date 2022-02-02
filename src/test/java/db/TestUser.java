package db;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DBConfig;
import db.vo.UserVO;

public class TestUser {
	private static SpringDAO dao;
	private static ApplicationContext container;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// 1. 컨테이너 구동
		container = new AnnotationConfigApplicationContext(
				DBConfig.class);
		dao = (SpringDAO) container.getBean("springDAO");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectBuyer() throws Exception{
		String id = "admin";
		String userType = "buyer";
		UserVO vo = dao.selectUser(id, userType);
		assertNotNull(vo);
		assertEquals(id, vo.getId());
	}

}
