package controller.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import db.vo.UserVO;

@Controller
@RequestMapping("/join.do")
public class JoinController {
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private JoinService joinService;
	
	@GetMapping
	public String viewJoinPage(Model model) {
		LOGGER.debug("회원가입 화면 출력");
		// <form:form> 사용 위해서 커맨드 객체를 모델에 넣어줌.
		UserVO vo = new UserVO();
		model.addAttribute("userVO", vo);
		return "JoinPage";
	}
	
	@PostMapping
	public String joinStart(@Valid UserVO vo, Errors error) {
		if(error.hasErrors()) {
			LOGGER.debug("회원가입에 오류가 있다아");
			return "JoinPage";
		}
		try {
			joinService.doJoin(vo);
		}catch(JoinFailException e) {
			LOGGER.debug("회원가입 실패");
			return "JoinPage";
		}catch(DuplicateKeyException e) {
			LOGGER.debug("중복된 아이디");
			return "JoinPage";
		}
		return "redirect:main";
	}
}
