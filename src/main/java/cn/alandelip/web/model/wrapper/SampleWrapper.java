package cn.alandelip.web.model.wrapper;

import cn.alandelip.entity.SampleData;
import cn.alandelip.exception.TransformException;
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
			throw new TransformException("wrap fails");
		}
	}

	public SampleData unwrap(SampleVO sampleVO) {
		if (sampleVO != null) {
			SampleData sampleData = new SampleData();
			BeanUtils.copyProperties(sampleVO, sampleData);
			return sampleData;
		} else {
			throw new TransformException("unwrap fails");
		}
	}
}
