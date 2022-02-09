package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class HomeController {
	@Autowired
	private static Logger LOGGER = LogManager.getLogger();
	
	@GetMapping
	public String homeController() {
		LOGGER.debug("메인 페이지 접속");
		return "main";
	}
}
