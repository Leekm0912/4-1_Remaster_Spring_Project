package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SampleRowMapper implements RowMapper<SampleVO> {
	@Override
	public SampleVO mapRow(ResultSet rs, int rowNum) 
		throws SQLException {
		SampleVO sample = new SampleVO();
//		System.out.println("가져온 ResultSet 테스트 ID :"+rs.getString("ID"));
//		System.out.println("가져온 ResultSet 테스트 Title :"+rs.getString("TITLE"));
		sample.setId(rs.getString("ID"));
		sample.setTitle(rs.getString("TITLE"));
		sample.setRegUser(rs.getString("REG_USER"));
		sample.setContent(rs.getString("CONTENT"));
		sample.setRegDate(rs.getDate("REG_DATE"));
//		System.err.println("만든 sample 확인" + sample);
		return sample;
	}
}

