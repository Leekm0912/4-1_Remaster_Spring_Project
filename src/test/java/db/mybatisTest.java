package db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import db.mybatis.TimeMapper;

@ContextConfiguration(classes = {config.DBConfig.class})
public class mybatisTest {
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private TimeMapper timeMapper;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Test
	public void testTimeMapper() throws Exception {
		LOGGER.debug(timeMapper.getClass().getName());
		LOGGER.debug(timeMapper.getTime());
	}
	
	@Test
	public void testSqlSessionFactory() throws Exception {
		LOGGER.debug(sqlSessionFactory.openSession());
	}
	
	@Test
	public void testSqlSessionTemplate() {
		LOGGER.debug(sqlSessionTemplate.getConnection());
	}

}
