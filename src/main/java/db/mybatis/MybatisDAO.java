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
	public UserVO selectUser(Map<String, String> data) throws DataAccessException;

	public int insertUser(UserVO vo);
	
	public void addOrder(ItemVO vo) throws Exception;

	public void deleteOrder(int vo) throws Exception;

	public List<ItemVO> viewTrading();

	public List<ItemVO> viewCharter();

	public List<ItemVO> viewMonthlyRent();

	public List<ItemVO> viewLand();
}
