package db.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import db.db_interface.DAOInterface;
import db.vo.ItemVO;
import db.vo.UserVO;

@Mapper
public interface MybatisDAO extends DAOInterface{
// 여기서 아래처럼 다시 선언 안해줘도 extends로 필요한 인터페이스 지정하면 자동으로 만들어 주는듯함! 멋지네
//	public UserVO selectUser(Map<String, String> data) throws DataAccessException;
//
//	public int insertUser(UserVO vo);
//	
//	public void addOrder(ItemVO vo) throws Exception;
//
//	public void deleteOrder(int vo) throws Exception;
//	
//	public List<Map<String,ItemVO>> viewItemAsMap(String selectItem);
//	
//	public List<ItemVO> viewItemAsList(String selectItem);
}
