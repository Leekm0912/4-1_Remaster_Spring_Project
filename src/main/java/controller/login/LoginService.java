package controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private DAOInterface dao;
	
	public UserVO login(LoginCommand vo) {
		UserVO result = null;
		try {
			Map<String, String> data = new HashMap<>();
			data.put("id", vo.getId());
			data.put("userType", vo.getUserType());
			result = dao.selectUser(data);
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
		LOGGER.debug("Service 확인 "+result.getName());
		return result;
	}
	
	public void checkUserType(HttpSession sess, LoginCommand vo) {
		String userType = vo.getUserType();
		if (userType.equals("kakao매수자") || userType.equals("매수자")) {
			sess.setAttribute("userType", "매수자");
			vo.setUserType("buyer");
		} else if (userType.equals("kakao매도자") || userType.equals("매도자")) {
			sess.setAttribute("userType", "매도자");
			vo.setUserType("seller");
		}
	}
}
