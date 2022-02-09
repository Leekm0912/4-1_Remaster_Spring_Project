package db;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import db.db_interface.DAOInterface;
import db.rowmapper.ItemRowMapper_detailItem_charter;
import db.rowmapper.ItemRowMapper_detailItem_trading;
import db.rowmapper.UserRowMapper;
import db.vo.ItemVO;
import db.vo.UserVO;


//@Repository("daoSpring")
public class SpringDAO implements DAOInterface{
	private static Logger LOGGER = LogManager.getLogger();
	
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어들
	private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID, TITLE, REG_USER, CONTENT, REG_DATE) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?, REG_USER=?, CONTENT=? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_LIST = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE ORDER BY REG_DATE DESC";
	private final String SAMPLE_LIST_TITLE = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE TITLE LIKE '%'||?||'%' ORDER BY REG_DATE DESC";
	private final String SAMPLE_LIST_CONTENT = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE CONTENT LIKE '%'||?||'%' ORDER BY REG_DATE DESC";

	private final String SELECTBUYER = "select * from buyer where id=?";
	private final String SELECTSELLER = "select * from seller where id=?";
	private final String INSERTBUYER = "insert into buyer values(?, ?, ?, ?)";
	private final String INSERTSELLER = "insert into seller values(?, ?, ?, ?)";
	
	private final String VIEW_TRADING = "select * from detailItem_trading order by itemNumber";
	private final String VIEW_CHARTER = "select * from detailItem_charter order by itemNumber";
	
	
	@Autowired
	public SpringDAO(DataSource dataSource) {
		LOGGER.debug("===> SpringDAO 생성");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert() throws Exception {
//		LOGGER.debug("===> Spring으로 insertSample() 기능 처리");
//		Object[] args = {vo.getId(), vo.getTitle(), vo.getRegUser(), 
//			vo.getContent()};
//		spring.update(SAMPLE_INSERT, args);
	}	

	
	public void update() throws Exception {
//		LOGGER.debug("===> Spring으로 updateSample() 기능 처리");
//		Object[] args = {vo.getId(), vo.getTitle(), vo.getRegUser(), vo.getContent(), vo.getId()};
//		spring.update(SAMPLE_UPDATE, args);
	}
	
	public void delete() throws Exception {
//		LOGGER.debug("===> Spring으로 deleteSample() 기능 처리");
//		spring.update(SAMPLE_DELETE, vo.getId());
	}
	
	@Override
	public UserVO selectUser(String id, String userType) throws DataAccessException {
		LOGGER.debug("===> Spring으로 selectBuyer() 기능 처리");
		Object[] args = {id};
		
		UserVO temp = null;
		if(userType.equals("buyer")) {
			temp = jdbcTemplate.queryForObject(SELECTBUYER, args, 
				new UserRowMapper());
		}else if(userType.equals("seller")) {
			temp = jdbcTemplate.queryForObject(SELECTSELLER, args, 
					new UserRowMapper());
		}
		LOGGER.debug("★★★★★★★★★★★★★넘어온 값 " + temp);
		return temp;
	}
	
	@Override
	public int insertUser(UserVO vo){
		Object[] args = {vo.getId(), vo.getPw(), vo.getName(), vo.getPhoneNumber()};
		if(vo.getUserType().equals("buyer")) {
			return jdbcTemplate.update(INSERTBUYER, args);
		}else if(vo.getUserType().equals("seller")) {
			return jdbcTemplate.update(INSERTSELLER, args);
		}
		return -1;
	}
	
	@Override
	public List<ItemVO> viewTrading(){
		LOGGER.debug("===> Spring으로 viewTrading() 기능 처리");
		List<ItemVO> temp = new ArrayList<>();
		temp = jdbcTemplate.query(VIEW_TRADING, new ItemRowMapper_detailItem_trading());
		return temp;
	}
	
	@Override
	public List<ItemVO> viewCharter(){
		LOGGER.debug("===> Spring으로 viewCharter() 기능 처리");
		List<ItemVO> temp = new ArrayList<>();
		temp = jdbcTemplate.query(VIEW_CHARTER, new ItemRowMapper_detailItem_charter());
		return temp;
	}

	@Override
	public void addOrder(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(int vo) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
