package controller.mybatisTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import db.mybatis.TimeMapper;

@Controller
@RequestMapping("/test")
public class MybatisTestController {
	@Autowired
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private TimeMapper timeMapper;
	
	@GetMapping
	public String homeController(Model model) {
		LOGGER.debug("mybatis 테스트 페이지 접속");
		LOGGER.debug("timeMapper" + timeMapper);
		LOGGER.debug("getTime1 : " + timeMapper.getTime());
		LOGGER.debug("getTime2 : " + timeMapper.getTime3());
		model.addAttribute("time", timeMapper.getTime3());
		return "test";
	}
}
