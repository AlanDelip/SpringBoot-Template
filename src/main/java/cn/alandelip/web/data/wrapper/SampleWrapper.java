package cn.alandelip.web.data.wrapper;

import cn.alandelip.model.SampleData;
import cn.alandelip.web.data.SampleVO;
import org.springframework.stereotype.Service;

/**
 * @author Alan on 2017/3/14
 */
@Service
public class SampleWrapper {
	public SampleVO wrap(SampleData sampleData) {
		if (sampleData != null) {
			SampleVO sampleVO = new SampleVO();
			sampleVO.setId(sampleData.getId());
			sampleVO.setName(sampleData.getName());
			sampleVO.setDetail(sampleData.getDetail());
			return sampleVO;
		} else {
			return null;
		}
	}
}
