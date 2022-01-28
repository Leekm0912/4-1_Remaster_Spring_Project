package db;

import java.util.List;

public interface SampleDAO {

	void insert(SampleVO vo) throws Exception;

	void delete(SampleVO vo) throws Exception;

	void update(SampleVO vo) throws Exception;

	SampleVO select(SampleVO vo) throws Exception;

	List<SampleVO> selectAll(SampleVO vo) throws Exception;

}