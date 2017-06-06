package cn.alandelip.web.logic;

import cn.alandelip.web.data.OperationStatus;
import cn.alandelip.web.data.SampleVO;

/**
 * @author Alan on 2017/3/14
 */
public interface SampleLogic {
	SampleVO getSampleData(long id);

	OperationStatus save(String name, String detail);

	OperationStatus put(long id, String name, String detail);

	OperationStatus delete(long id);
}
