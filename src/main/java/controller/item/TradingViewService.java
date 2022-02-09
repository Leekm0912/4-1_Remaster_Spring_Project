package controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.db_interface.DAOInterface;
import db.vo.ItemVO;

@Service
public class TradingViewService {
	@Autowired
	DAOInterface dao;
	
	public List<ItemVO> view() throws ItemSearchException{
		List<ItemVO> item = dao.viewTrading();
		if(item == null) {
			throw new ItemSearchException();
		}
		item.stream()
		.forEach(v->{
			System.out.println(v);
		});
		return item;
	}
}
