package db.db_interface;

import java.util.List;
import db.vo.UserVO;

public interface UserInterface {
	public UserVO selectBuyer(String id) throws Exception;
}