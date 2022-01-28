package db.db_interface;

import db.vo.ItemVO;

public interface OrderInterface {
	void addOrder(ItemVO vo) throws Exception;

	void deleteOrder(int vo) throws Exception;
}
