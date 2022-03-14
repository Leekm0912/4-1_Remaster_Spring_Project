package db;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import db.mybatis.MybatisDAO;
import db.mybatis.TimeMapper;
import db.vo.ItemVO;
import db.vo.UserVO;

// @ContextConfiguration : 불러올 설정파일.
// java 설정파일의 경우는 .class 형식을 불러오고
// xml 방식의 설정파일은 classpath:xml파일경로 로 불러옴.
// 테스트 할때 classpath의 root는 src/test/resources임.
// 개발에서 사용하는 파일을 불러올때는 file:Full path 형식으로 불러오면 됨. 
// ex) @ContextConfiguration(locations = "/root-context.xml")
@ContextConfiguration(classes = { 
		config.DBConfig.class, 
		config.PropertyConfig.class
})
// 사용할 프로필 선택
@ActiveProfiles("docker")
// 스프링 테스트를 위해 junit을 확장시켜 스프링 컨테이너를 만들어줌
@RunWith(SpringJUnit4ClassRunner.class)
public class mybatisTest {
	private static Logger LOGGER = LogManager.getLogger();

	// Autowired 할 bean은 static이면 안됨.
	@Autowired
	private TimeMapper timeMapper;
	
	@Autowired
	private MybatisDAO mybatisDAO;

	@Ignore
	public void testTimeMapper() throws Exception {
		assertNotNull(timeMapper);
		LOGGER.debug("@@@@@timeMapper : " + timeMapper.getClass().getName());
		LOGGER.debug("@@@@@timeMapper getTime() : " + timeMapper.getTime());
		LOGGER.debug("@@@@@timeMapper getTime3() : " + timeMapper.getTime3());
	}
	
	@Test
	public void testSelectBuyer() throws Exception {
		assertNotNull(mybatisDAO);
		Map<String, String> m = new HashMap<>();
		m.put("id", "admin");
		m.put("userType", "buyer");
		UserVO vo = mybatisDAO.selectUser(m);
		LOGGER.debug("@@@@@mybatisDAO selectUser(\"1\", \"buyer\") : " + vo);
		assertEquals("관리자(매수)", vo.getName());
		assertEquals("admin", vo.getId());
		
		m = new HashMap<>();
		m.put("id", "admin");
		m.put("userType", "seller");
		vo = mybatisDAO.selectUser(m);
		LOGGER.debug("@@@@@mybatisDAO selectUser(\"1\", \"seller\") : " + vo);
		assertEquals("관리자(매도)", vo.getName());
		assertEquals("admin", vo.getId());
	}
	
	@Test
	public void testViewItemAsMap() throws Exception {
		assertNotNull(mybatisDAO);
		List<Map<String, ItemVO>> vo = mybatisDAO.viewItemAsMap("test");
		LOGGER.debug("@@@@@mybatisDAO viewItemAsMap(\"test) : " + vo);

		vo.stream()
		.forEach((map)->{
			map.keySet().stream()
			.forEach(key->{
				LOGGER.debug("[결과] key : "+ key + "\tvalue : " + map.get(key));
			});
			LOGGER.debug("=======================================================");
		});
	}
	
	@Test
	public void testViewItemAsList() throws Exception {
		assertNotNull(mybatisDAO);
		List<ItemVO> vo = mybatisDAO.viewItemAsList("test");
		LOGGER.debug("@@@@@mybatisDAO viewItemAsList(\"test) : " + vo);

		vo.stream()
		.forEach((v)->{
			LOGGER.debug("[결과] v : "+ v);
			LOGGER.debug("★★★★★★★★★★★★★★★★★★★★★★");
		});
	}
}
