/**
 * MiracleCat Project
 * Copyright 2016 https://github.com/miracle134
 */
package com.mc.miraclecat.main.service.impl;

import org.springframework.stereotype.Service;

import com.mc.miraclecat.main.service.MainService;


/**
 * @Name MainServiceImpl.java
 * @Description  
 *
 * @Modification Information
 * @
 * @author MiracleCat (miraclecat@itnes.co.kr)
 * @since 2021. 2. 18.
 * @
 * @ 수정일          수정자                  수정내용
 * @ ----------   ---------------   ---------------
 * @
 */
@Service(value="mainService")
public class MainServiceImpl implements MainService {
	
//	/** SampleDAO */
//    @Autowired
//	private SampleDAO sampleDAO;
//
//    /** SampleRepository */
//    @Autowired
//    private SampleRepository sampleRepository;
//
//    /** CompanyRepository */
//    @Autowired
//    private CompanyRepository companyRepository;
//
//	@Override
//	public List<Sample> getSampleList() throws Exception {
//
//		return sampleRepository.findAll();
//	}
//
//	@Override
//	public Sample selectDetail(SampleVO vo) throws Exception {
//
//		return sampleRepository.findBySeqAndName(vo.getSSeq(),vo.getSName());
//	}
//
//	@Override
//	public Long sampleSave(SampleVO vo) throws Exception {
//
//		Sample entity = Sample.InsertSampleBuilder().vo(vo).build();
//
//		return sampleRepository.save(entity).getSeq();
//	}
//
//	@Override
//	@Transactional(transactionManager="jpaTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//	public void sampleUpdate(SampleVO vo) throws Exception {
//		try {
//			Optional<Sample> result = sampleRepository.findById(vo.getSSeq());
//			result.orElseThrow(() -> new Exception("해당 ID 정보 없음"));
//
//			result.get().updateInfo(vo);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
//
//	@Override
//	public void sampleDelete(SampleVO vo) throws Exception {
//		sampleRepository.deleteById(vo.getSSeq());
//	}
//
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//	public List<Sample> selectMybatisDB1(SampleVO vo) throws Exception {
//		return sampleDAO.selectMybatisDB1(vo);
//	}

}
