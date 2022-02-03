package controller.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
	
	@GetMapping
	public String viewJoinPage() {
		System.out.println("회원가입 화면 출력");
		return "DB/join";
	}
	
	@PostMapping
	public String joinStart(HttpSession sess, UserVO vo, Errors error, Model model) {
		return null;
	}
}
