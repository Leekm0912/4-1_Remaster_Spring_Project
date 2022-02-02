package db.db_interface;

import org.springframework.dao.DataAccessException;

import db.vo.UserVO;

public interface UserInterface {
	public UserVO selectUser(String id, String userType) throws DataAccessException;
}