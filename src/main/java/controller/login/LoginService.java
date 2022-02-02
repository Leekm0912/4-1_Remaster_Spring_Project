package controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import db.SpringDAO;
import db.vo.UserVO;

@Component
public class LoginService {
	@Autowired
	private SpringDAO dao;
	
	public UserVO login(UserVO vo) throws Exception {
		UserVO result = dao.selectBuyer(vo.getId());
		if(result == null || !result.getId().equals(vo.getId()) || !result.getPw().equals(vo.getPw())) {
			throw new LoginException();
		}
		result.setPw(null); // 비밀번호 검증 후 지움.
		result.setUserType(vo.getUserType());
//		System.out.println("Service 확인 "+result.getName());
		return result;
	}
}
