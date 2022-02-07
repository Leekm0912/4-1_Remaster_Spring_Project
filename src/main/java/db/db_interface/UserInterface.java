package db.db_interface;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import db.vo.UserVO;

public interface UserInterface {
	public UserVO selectUser(String id, String userType) throws DataAccessException;

	@Transactional
	public int insertUser(UserVO vo);
}