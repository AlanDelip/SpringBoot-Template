package cn.alandelip.web.logic.impl;

import cn.alandelip.constants.ErrorCode;
import cn.alandelip.model.SampleData;
import cn.alandelip.service.SampleService;
import cn.alandelip.web.data.Response;
import cn.alandelip.web.data.SampleVO;
import cn.alandelip.web.data.wrapper.SampleWrapper;
import cn.alandelip.web.logic.SampleLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alan on 2017/3/14
 */
@Service
public class SampleLogicImpl implements SampleLogic {

	private SampleService sampleService;
	private SampleWrapper sampleWrapper;

	@Autowired
	public SampleLogicImpl(SampleService sampleService, SampleWrapper sampleWrapper) {
		this.sampleService = sampleService;
		this.sampleWrapper = sampleWrapper;
	}

	@Override
	public Response<SampleVO> getSampleData(long id) {
		SampleData sampleData = sampleService.getSample(id);
		return sampleWrapper.wrap(sampleData);
	}

	@Override
	public Response save(String name, String detail) {
		if (sampleService.save(name, detail)) {
			return Response.success();
		} else {
			return Response.fail(ErrorCode.SAVE_ERROR);
		}
	}
}
