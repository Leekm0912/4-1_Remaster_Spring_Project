package controller.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@Autowired
	private JoinService joinService;
	
	@GetMapping
	public String viewJoinPage() {
		System.out.println("회원가입 화면 출력");
		return "DB/join";
	}
	
	@PostMapping
	public String joinStart(UserVO vo, Errors error) {
		try {
			joinService.doJoin(vo);
		}catch(JoinFailException e) {
			System.out.println("회원가입 실패");
			return "DB/join";
		}catch(DuplicateKeyException e) {
			System.out.println("중복된 아이디");
			return "DB/join";
		}
		return "redirect:main";
	}
}
