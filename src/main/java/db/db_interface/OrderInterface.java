package db.db_interface;

import java.util.List;

import db.vo.ItemVO;

public interface OrderInterface {
	public void addOrder(ItemVO vo) throws Exception;

	public void deleteOrder(int vo) throws Exception;

	public List<ItemVO> viewTrading();

	public List<ItemVO> viewCharter();

	public List<ItemVO> viewMonthlyRent();

	public List<ItemVO> viewLand();
}
