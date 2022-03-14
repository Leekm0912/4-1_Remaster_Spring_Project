package db.db_interface;

import java.util.List;
import java.util.Map;

import db.vo.ItemVO;

public interface OrderInterface {
	public int addOrder(ItemVO vo);
	
	public int addItem(ItemVO vo);

	public int deleteOrder(int itemNumber);
	
	public int deleteItem(int itemNumber);

	public List<Map<String,ItemVO>> viewItemAsMap(Map<String, String> selectItem);
	
	public List<ItemVO> viewItemAsList(Map<String, String> selectItem);
	
	public int getRecentItemNumber();
}
