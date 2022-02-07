package controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
	@Autowired
	private LoginService loginService;

	@GetMapping
	public String viewLoginPage(Model model) {
		System.out.println("로그인 화면 출력");
		// <form:form> 사용 위해서 커맨드 객체를 모델에 넣어줌.
		LoginCommand vo = new LoginCommand();
		model.addAttribute("loginCommand", vo);
		return "DB/login";
	}

	@PostMapping
	public String loginStart(HttpSession sess, @Valid LoginCommand vo, Errors error, Model model) {
		System.out.println("로그인 시작");
		if (error.hasErrors()) {
			System.out.println("로그인 검증 중 에러");
			return "DB/login";
		}
		System.out.println("파라미터 id : " + vo.getId());
		System.out.println("파라미터 Pw : " + vo.getPw());
		System.out.println("파라미터 userType : " + vo.getUserType());
		UserVO userInfo = null;
		String temp = vo.getUserType();
		if (temp.equals("kakao매수자") || temp.equals("매수자")) {
			sess.setAttribute("userType", "매수자");
			vo.setUserType("buyer");
		} else if (temp.equals("kakao매도자") || temp.equals("매도자")) {
			sess.setAttribute("userType", "매도자");
			vo.setUserType("seller");
		}
		try {
			userInfo = loginService.login(vo);
		} catch (LoginException e) {
//			e.printStackTrace();
			System.err.println("service error : " + e.getClass().getName());
			sess.removeAttribute("userType");
			System.out.println("로그인 에러 발생!!");
			// 안넣어주면 에러.
			model.addAttribute("loginCommand", vo);
			// 이런 에러 메시지 다 리소스로 분리해야함
			model.addAttribute("hasError", "["+ e.getClass().getName() +"]\n존재하지 않는 아이디 이거나, 잘못된 비밀번호 입니다.");
			return "DB/login";
		}
//		System.out.println("컨트롤러 확인 " + userInfo);
		sess.setAttribute("userInfo", userInfo);
		model.addAttribute("userName", userInfo.getName());
		return "redirect:main";
	}
}
