package controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import db.SpringDAO;
import db.db_interface.DAOInterface;
import db.vo.LoginCommand;
import db.vo.UserVO;

@Service
public class LoginService {
	@Autowired
	private DAOInterface dao;
	
	public UserVO login(LoginCommand vo) {
		UserVO result = null;
		try {
			result = dao.selectUser(vo.getId(), vo.getUserType());
		}catch(DataAccessException e) {
//			e.printStackTrace();
			System.err.println("DataAccessException");
			throw new LoginException();
		}
		if(!result.getPw().equals(vo.getPw())) {
			throw new PwNotMatchException();
		}
		result.setPw(null); // 비밀번호 검증 후 지움.
		result.setUserType(vo.getUserType());
//		System.out.println("Service 확인 "+result.getName());
		return result;
	}
}
