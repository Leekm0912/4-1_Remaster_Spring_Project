package db;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import db.db_interface.DAOInterface;
import db.vo.UserVO;


//@Repository("daoSpring")
public class SpringDAO {
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어들
	private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID, TITLE, REG_USER, CONTENT, REG_DATE) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?, REG_USER=?, CONTENT=? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_LIST = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE ORDER BY REG_DATE DESC";
	private final String SAMPLE_LIST_TITLE = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE TITLE LIKE '%'||?||'%' ORDER BY REG_DATE DESC";
	private final String SAMPLE_LIST_CONTENT = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE CONTENT LIKE '%'||?||'%' ORDER BY REG_DATE DESC";

	private final String SelectBuyer = "select * from buyer where id=?";
	private final String SelectSeller = "select * from seller where id=?";
	
	@Autowired
	public SpringDAO(DataSource dataSource) {
		System.out.println("===> SpringDAO 생성");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert() throws Exception {
//		System.out.println("===> Spring으로 insertSample() 기능 처리");
//		Object[] args = {vo.getId(), vo.getTitle(), vo.getRegUser(), 
//			vo.getContent()};
//		spring.update(SAMPLE_INSERT, args);
	}	

	
	public void update() throws Exception {
//		System.out.println("===> Spring으로 updateSample() 기능 처리");
//		Object[] args = {vo.getId(), vo.getTitle(), vo.getRegUser(), vo.getContent(), vo.getId()};
//		spring.update(SAMPLE_UPDATE, args);
	}
	
	public void delete() throws Exception {
//		System.out.println("===> Spring으로 deleteSample() 기능 처리");
//		spring.update(SAMPLE_DELETE, vo.getId());
	}
	
	public UserVO selectBuyer(String id) throws Exception {
		System.out.println("===> Spring으로 selectBuyer() 기능 처리");
		Object[] args = {id};
		UserVO temp = jdbcTemplate.queryForObject(SelectBuyer, args, 
				new UserRowMapper());
		System.out.println("★★★★★★★★★★★★★넘어온 값 " + temp);
		return temp;
	}
	
	public List<Object> selectAll() throws Exception {
//		System.out.println("===> Spring으로 selectSampleList() 기능 처리");
//		return spring.query(SAMPLE_LIST, new SampleRowMapper());
		return null;
	}
}
