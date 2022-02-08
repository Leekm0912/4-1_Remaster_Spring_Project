package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import db.vo.ItemVO;
import db.vo.UserVO;

public class ItemRowMapper_detailView implements RowMapper<ItemVO> 
{
	@Override
	public ItemVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemVO sample = new ItemVO();
		sample.setAddress(rs.getNString("address"));
		sample.setItemAddDate(rs.getDate("itemAddDate"));
		sample.setItemNumber((rs.getInt("itemNumber")));
		sample.setPrice((rs.getInt("price")));
		return sample;
	}
}

