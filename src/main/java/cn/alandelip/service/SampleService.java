package cn.alandelip.service;

import cn.alandelip.model.SampleData;
import cn.alandelip.web.data.SampleVO;

import java.util.List;

/**
 * @author Alan on 2017/3/14
 */
public interface SampleService {
	SampleData getSample(long id);

	Boolean save(String name, String detail);

	Boolean put(long id, String name, String detail);

	Boolean delete(long id);

	List<SampleData> getSamples();
}
