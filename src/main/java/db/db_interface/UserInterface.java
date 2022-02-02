package db.db_interface;

import org.springframework.dao.DataAccessException;

import db.vo.UserVO;

public interface UserInterface {
	public UserVO selectBuyer(String id) throws DataAccessException;
}