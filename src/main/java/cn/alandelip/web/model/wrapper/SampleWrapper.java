package cn.alandelip.web.model.wrapper;

import cn.alandelip.entity.SampleData;
import cn.alandelip.web.model.SampleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author Alan on 2017/3/14
 */
@Service
public class SampleWrapper {
	public SampleVO wrap(SampleData sampleData) {
		if (sampleData != null) {
			SampleVO sampleVO = new SampleVO();
			BeanUtils.copyProperties(sampleData, sampleVO);
			return sampleVO;
		} else {
			return null;
		}
	}
}
