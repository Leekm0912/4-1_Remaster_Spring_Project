package controller.logout;

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
@RequestMapping("/logout.do")
public class LogOutController {
	
	@GetMapping
	public String viewLoginPage(HttpSession sess) {
		System.out.println("로그아웃");
		sess.invalidate();
		//sess.removeAttribute("userType");
		return "redirect:main";
	}
}
