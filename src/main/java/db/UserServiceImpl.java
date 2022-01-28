package db;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import db.db_interface.DAOInterface;
import db.db_interface.OrderInterface;
import db.db_interface.UserInterface;
import db.vo.UserVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

//@Service
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserInterface {
	@Autowired 
	//@Qualifier("mybatis")
	private DAOInterface sampleDAO;
	private String version;
	@Autowired
	private EgovIdGnrService egovIdGnrService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	public void init() {
		System.out.println("===> init 호출");
	}
	
	public UserServiceImpl() throws Exception {
		System.out.println("====> SampleServiceImpl 생성");
	}

//	@Override
//	public void insertSample(SampleVO vo) throws Exception {
//		String id = this.egovIdGnrService.getNextStringId();
//		vo.setId(id);
//		sampleDAO.insert(vo);
//	}
//
//	@Override
//	public void updateSample(SampleVO vo) throws Exception {
//		sampleDAO.update(vo);
//	}
//
//	@Override
//	public void deleteSample(SampleVO vo) throws Exception {
//		sampleDAO.delete(vo);
//	}
//
//	@Override
//	public SampleVO selectSample(SampleVO vo) throws Exception {
//		SampleVO temp2 = sampleDAO.select(vo);
////		System.out.println("※※※※※※※※※※※※※※※※※※※selectSample"+temp2);
//		LOGGER.trace("TRACE LEVEL Logging");
//		LOGGER.debug("DEBUG LEVEL Logging");
//		LOGGER.info("INFO LEVEL Logging");
//		LOGGER.warn("WARN LEVEL Logging");
//		LOGGER.error("ERROR LEVEL Logging");
//		return temp2;
//	}
//
//	@Override
//	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
//		return sampleDAO.selectAll(vo);
//	}

	@Override
	public void insertUser(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String userID) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO selectUser(String userID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> selectUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
