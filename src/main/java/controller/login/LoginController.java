package controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import db.vo.UserVO;

@Controller
@RequestMapping("/login.do")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping
	public String viewLoginPage() {
		System.out.println("로그인 화면 출력");
		return "DB/login";
	}
	
	@PostMapping
	public String loginStart(HttpSession sess, UserVO vo, Errors error, Model model) {
		System.out.println("로그인 시작");
		System.out.println(vo.getId());
		UserVO userInfo = null;
		try {
			userInfo = loginService.login(vo);
		}catch(LoginException e) {
			e.printStackTrace();
			return "redirect:login.do";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "redirect:login.do";
		}
//		System.out.println("컨트롤러 확인 " + userInfo);
		sess.setAttribute("userInfo", userInfo);
		sess.setAttribute("userType", userInfo.getUserType());
		model.addAttribute("userName", userInfo.getName());
		return "redirect:main";
	}
}
