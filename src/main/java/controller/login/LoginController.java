package controller.login;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import db.vo.LoginCommand;
import db.vo.UserVO;

@Controller
@RequestMapping("/login.do")
public class LoginController {
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private LoginService loginService;

	@GetMapping
	public String viewLoginPage(Model model) {
		LOGGER.debug("로그인 화면 출력");
		// <form:form> 사용 위해서 커맨드 객체를 모델에 넣어줌.
		LoginCommand vo = new LoginCommand();
		model.addAttribute("loginCommand", vo);
		return "LoginPage";
	}

	@PostMapping
	public String loginStart(HttpSession sess, @Valid LoginCommand vo, Errors error, Model model) {
		LOGGER.debug("로그인 시작");
		if (error.hasErrors()) {
			LOGGER.debug("로그인 검증 중 에러");
			return "LoginPage";
		}
		LOGGER.debug("파라미터 id : " + vo.getId());
		LOGGER.debug("파라미터 userType : " + vo.getUserType());
		LOGGER.debug("파라미터 pw : " + vo.getPw());
		
		// userType이 카카오 로그인인지 일반 로그인인지 확인 후 VO에 알맞게 저장해줌. 
		loginService.checkUserType(sess, vo);
		
		UserVO userInfo = null;
		try {
			// 로그인 작업 수행. 일치하는 아이디 없거나, 비번 틀리면 예외 발생.
			userInfo = loginService.login(vo);
		} catch (LoginException e) {
//			e.printStackTrace();
			System.err.println("service error : " + e.getClass().getName());
			sess.removeAttribute("userType");
			LOGGER.debug("로그인 에러 발생!!");
			// 안넣어주면 에러.
			model.addAttribute("loginCommand", vo);
			// 이런 에러 메시지 다 리소스로 분리해야함
			model.addAttribute("hasError", 
					"["+ e.getClass().getName() +"]\n존재하지 않는 아이디 이거나, 잘못된 비밀번호 입니다.");
			return "LoginPage";
		}
		sess.setAttribute("userInfo", userInfo);
		model.addAttribute("userName", userInfo.getName());
		return "redirect:main";
	}
}
