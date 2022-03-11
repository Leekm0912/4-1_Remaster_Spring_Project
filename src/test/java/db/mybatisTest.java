package db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import config.DBConfig;
import db.mybatis.TimeMapper;

//@ContextConfiguration(classes = {config.DBConfig.class})
public class mybatisTest {
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private static TimeMapper timeMapper;
	
	private static ApplicationContext container;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// 1. 컨테이너 구동
		container = new AnnotationConfigApplicationContext(
				config.DBConfig.class);
		timeMapper = (TimeMapper) container.getBean("timeMapper");

	}
	
	@Test
	public void testTimeMapper() throws Exception {
		LOGGER.debug(timeMapper.getClass().getName());
		LOGGER.debug(timeMapper.getTime());
	}
	
//	@Test
//	public void testSqlSessionFactory() throws Exception {
//		LOGGER.debug(sqlSessionFactory.openSession());
//	}
//	
//	@Test
//	public void testSqlSessionTemplate() {
//		LOGGER.debug(sqlSessionTemplate.getConnection());
//	}

}
