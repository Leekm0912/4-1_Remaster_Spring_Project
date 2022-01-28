package db.db_interface;

import java.util.List;
import db.vo.UserVO;

public interface UserInterface {
	void insertUser(UserVO vo) throws Exception;

	void updateUser(UserVO vo) throws Exception;

	void deleteUser(String userID) throws Exception;

	UserVO selectUser(String userID) throws Exception;

	List<UserVO> selectUserList() throws Exception;
}