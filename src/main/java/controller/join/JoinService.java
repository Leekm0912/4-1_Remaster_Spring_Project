package controller.join;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import db.db_interface.DAOInterface;
import db.vo.UserVO;

@Service
public class JoinService {
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private DAOInterface dao;
	
	@Transactional
	public void doJoin(UserVO vo) throws JoinFailException{
		int result = dao.insertUser(vo);
		if(result>0) {
			LOGGER.debug("회원가입 성공, 가입된 아이디 : " + vo.getId());
			return;
		} else {
			throw new JoinFailException();
		}
	}
}
