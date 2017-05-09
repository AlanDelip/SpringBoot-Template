package cn.alandelip.web.data.wrapper;

import cn.alandelip.constants.ErrorCode;
import cn.alandelip.model.SampleData;
import cn.alandelip.web.data.Response;
import cn.alandelip.web.data.SampleVO;
import org.springframework.stereotype.Service;

/**
 * @author Alan on 2017/3/14
 */
@Service
public class SampleWrapper {
	public String wrap(SampleData sampleData) {
		if (sampleData != null) {
			SampleVO sampleVO = new SampleVO();
			sampleVO.setId(sampleData.getId());
			sampleVO.setName(sampleData.getName());
			return new Response<SampleVO>().getBuilder()
					.succ()
					.data(sampleVO)
					.build();
		} else {
			return new Response<SampleVO>().getBuilder()
					.failBuild(ErrorCode.NOT_FOUND);
		}
	}
}
