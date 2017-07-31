package cn.alandelip.web.data.wrapper;

import cn.alandelip.model.SampleData;
import cn.alandelip.web.data.SampleVO;
import com.fasterxml.jackson.annotation.JsonInclude;
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
