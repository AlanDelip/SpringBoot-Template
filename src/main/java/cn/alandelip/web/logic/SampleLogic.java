package cn.alandelip.web.logic;

import cn.alandelip.web.data.Response;
import cn.alandelip.web.data.SampleVO;

/**
 * @author Alan on 2017/3/14
 */
public interface SampleLogic {
	String getSampleData(long id);

	String save(String name, String detail);
}
