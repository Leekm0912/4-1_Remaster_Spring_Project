package controller.insertItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.db_interface.DAOInterface;
import db.vo.ItemVO;

@Service
public class InsertItemService {
	private static Logger LOGGER = LogManager.getLogger();
	@Autowired
	DAOInterface dao;
	
	public boolean insertItem(ItemVO vo) {
		int recentItemNumber = dao.getRecentItemNumber();
		vo.setItemNumber(recentItemNumber + 1);
		try {
			int result = dao.addItem(vo);
			if(result < 1) {
				throw new NotInsertItemException();
			}
		}catch (NotInsertItemException e) {
			LOGGER.error(e.getStackTrace());
			return false;
		}
		return true;
	}
}
