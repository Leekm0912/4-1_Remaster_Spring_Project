package db.db_interface;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import db.vo.UserVO;

public interface UserInterface {
	public UserVO selectUser(Map<String, String> data) throws DataAccessException;

	public int insertUser(UserVO vo);
}