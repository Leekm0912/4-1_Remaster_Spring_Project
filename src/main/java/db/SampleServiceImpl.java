package db;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import sample.db.SampleVO;

//@Service
public class SampleServiceImpl extends EgovAbstractServiceImpl implements SampleService {
	@Autowired 
	//@Qualifier("mybatis")
	private SampleDAO sampleDAO;
	private String version;
	@Autowired
	private EgovIdGnrService egovIdGnrService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

	
//	public SampleDAO getDao() {
//		return sampleDAO;
//	}
//
//	public void setDao(SampleDAO dao) {
//		System.out.println("setDao");
//		this.sampleDAO = dao;
//	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		System.out.println("setVersion");
		this.version = version;
	}

	public void init() {
		System.out.println("===> init 호출");
	}
	
	public SampleServiceImpl() throws Exception {
		System.out.println("====> SampleServiceImpl 생성");
	}

	@Override
	public void insertSample(SampleVO vo) throws Exception {
		String id = this.egovIdGnrService.getNextStringId();
		vo.setId(id);
		sampleDAO.insert(vo);
	}

	@Override
	public void updateSample(SampleVO vo) throws Exception {
		sampleDAO.update(vo);
	}

	@Override
	public void deleteSample(SampleVO vo) throws Exception {
		sampleDAO.delete(vo);
	}

	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		SampleVO temp2 = sampleDAO.select(vo);
//		System.out.println("※※※※※※※※※※※※※※※※※※※selectSample"+temp2);
		LOGGER.trace("TRACE LEVEL Logging");
		LOGGER.debug("DEBUG LEVEL Logging");
		LOGGER.info("INFO LEVEL Logging");
		LOGGER.warn("WARN LEVEL Logging");
		LOGGER.error("ERROR LEVEL Logging");
		return temp2;
	}

	@Override
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		return sampleDAO.selectAll(vo);
	}
}
