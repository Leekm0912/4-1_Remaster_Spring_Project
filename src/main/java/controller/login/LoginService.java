package controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import controller.join.JoinFailException;
import controller.join.JoinService;
import db.SpringDAO;
import db.db_interface.DAOInterface;
import db.vo.LoginCommand;
import db.vo.UserVO;

@Service
public class LoginService {
	private static Logger LOGGER = LogManager.getLogger();

	@Autowired
	private DAOInterface dao;
	@Autowired
	private JoinService joinService;

	public UserVO login(LoginCommand vo) {
		UserVO result = null;
		try {
			Map<String, String> data = new HashMap<>();
			data.put("id", vo.getId());
			String userType = vo.getUserType();
			LOGGER.debug("login userType : " + userType);
			// kakaoUser 프로퍼티는 ""로 초기화 되어있는데, 카카오로 로그인하면 로그인 방법이 저장됨.
			if (!vo.getKakaoUser().equals("")) {
//				if (vo.getKakaoUser().equals("kakao매수자")) {
//					userType = "buyer";
//				} else if (vo.getKakaoUser().equals("kakao매도자")) {
//					userType = "seller";
//				}
				LOGGER.debug("kakao 유저 회원가입 시작");
				UserVO userVO = new UserVO();
				userVO.setId(vo.getId());
				userVO.setPw(vo.getPw());
				userVO.setName(vo.getId());
				userVO.setPhoneNumber(vo.getPhoneNumber());
				userVO.setUserType(userType);
				try {
					joinService.doJoin(userVO);
				}catch(DuplicateKeyException e){
					LOGGER.debug("가입된 kakao id");
				}
				LOGGER.debug("회원가입 성공");
			}
			data.put("userType", userType);
			result = dao.selectUser(data);
		} catch (DataAccessException e) {
			e.printStackTrace();
			LOGGER.error("DataAccessException" + e.getStackTrace());
			throw new LoginException();
		}
		
		LOGGER.debug("selectUser result : " + result);
		if (!result.getPw().equals(vo.getPw())) {
			throw new PwNotMatchException();
		}
		result.setPw(null); // 비밀번호 검증 후 지움.
		result.setUserType(vo.getUserType());
		LOGGER.debug("Service 확인 " + result.getName());
		return result;
	}

	public void checkUserType(HttpSession sess, LoginCommand vo) {
		String userType = vo.getUserType();
		vo.setKakaoUser(userType);
		if (userType.equals("kakao매수자") || userType.equals("매수자")) {
			sess.setAttribute("userType", "매수자");
			vo.setUserType("buyer");
			
		} else if (userType.equals("kakao매도자") || userType.equals("매도자")) {
			sess.setAttribute("userType", "매도자");
			vo.setUserType("seller");
		}
	}
}
