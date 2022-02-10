package controller.item;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.db_interface.DAOInterface;
import db.vo.ItemVO;

@Service
public class ItemViewService {
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	DAOInterface dao;
	
	public List<String> makeMenuList(String menu){
		List<String> menuList = new ArrayList<>();
		while(menu.indexOf(",") != -1) {
			int index = menu.indexOf(",");
			String substr = menu.substring(0,index);
			menuList.add(substr);
			menu = menu.substring(index+1);
		}
		menuList.add(menu); // while문 빠져나온 후 남아있는 메뉴도 넣어줌.
		return menuList;
	}
	
	public List<ItemVO> getTradingData() throws ItemSearchException{
		List<ItemVO> item = dao.viewTrading();
		if(item == null) {
			throw new ItemSearchException();
		}
		item.stream()
		.forEach(v->{
			LOGGER.debug(v);
		});
		return item;
	}
	
	public List<ItemVO> getCharterData() throws ItemSearchException{
		List<ItemVO> item = dao.viewCharter();
		if(item == null) {
			throw new ItemSearchException();
		}
		item.stream()
		.forEach(v->{
			LOGGER.debug(v);
		});
		return item;
	}
	
	public List<ItemVO> getMonthlyRent() throws ItemSearchException{
		List<ItemVO> item = dao.viewMonthlyRent();
		if(item == null) {
			throw new ItemSearchException();
		}
		item.stream()
		.forEach(v->{
			LOGGER.debug(v);
		});
		return item;
	}
	
	public List<ItemVO> getLand() throws ItemSearchException{
		List<ItemVO> item = dao.viewLand();
		if(item == null) {
			throw new ItemSearchException();
		}
		item.stream()
		.forEach(v->{
			LOGGER.debug(v);
		});
		return item;
	}
}
