package controller.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.db_interface.DAOInterface;
import db.vo.UserVO;

@Service
public class JoinService {
	@Autowired
	private DAOInterface dao;
	
	public void doJoin(UserVO vo) throws JoinFailException{
		int result = dao.insertUser(vo);
		if(result>0) {
			return;
		} else {
			throw new JoinFailException();
		}
	}
}
