package db.db_interface;

import java.util.List;
import java.util.Map;

import db.vo.ItemVO;

public interface OrderInterface {
	public void addOrder(ItemVO vo) throws Exception;

	public void deleteOrder(int vo) throws Exception;

	public List<Map<String,ItemVO>> viewItemAsMap(String selectItem);
	
	public List<ItemVO> viewItemAsList(String selectItem);
}
