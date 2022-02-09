package db.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import db.vo.ItemVO;
import db.vo.UserVO;

public class ItemRowMapper_detailItem_charter implements RowMapper<ItemVO> 
{
	@Override
	public ItemVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemVO sample = new ItemVO();
		sample.setItemNumber((rs.getInt("itemNumber")));
		sample.setSellerName(rs.getString("sellerName"));
		sample.setAddress(rs.getString("address"));
		sample.setPrice((rs.getInt("price")));
		sample.setItemAddDate(rs.getDate("itemAddDate"));
		
		sample.setContractMonth(rs.getInt("contractMonth"));
		return sample;
	}
}

