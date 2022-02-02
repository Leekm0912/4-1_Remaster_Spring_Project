package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import db.vo.UserVO;

public class UserRowMapper implements RowMapper<UserVO> 
{
	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO sample = new UserVO();
//		System.out.println("가져온 ResultSet 테스트 ID :"+rs.getString("ID"));
//		System.out.println("가져온 ResultSet 테스트 Title :"+rs.getString("TITLE"));
		sample.setId(rs.getString("ID"));
		sample.setPw(rs.getString("PW"));
		sample.setName(rs.getString("name"));
		sample.setPhoneNumber(rs.getString("phoneNumber"));
//		System.err.println("만든 sample 확인" + sample);
		return sample;
	}
}

