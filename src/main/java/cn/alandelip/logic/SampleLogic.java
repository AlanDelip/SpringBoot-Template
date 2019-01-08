package cn.alandelip.logic;

import cn.alandelip.web.model.SampleVO;

import java.util.List;

/**
 * @author Alan on 2017/3/14
 */
public interface SampleLogic {
	SampleVO getSampleData(long id);

	void save(String name, String detail);

	void put(SampleVO sampleVO);

	void delete(long id);

	List<SampleVO> getSamples();
}
