package cn.alandelip.web.logic.impl;

import cn.alandelip.model.SampleData;
import cn.alandelip.service.SampleService;
import cn.alandelip.web.data.OperationStatus;
import cn.alandelip.web.data.SampleVO;
import cn.alandelip.web.data.wrapper.SampleWrapper;
import cn.alandelip.web.exception.NotFoundException;
import cn.alandelip.web.logic.SampleLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static cn.alandelip.web.data.OperationStatus.Status.FAILURE;
import static cn.alandelip.web.data.OperationStatus.Status.SUCCESS;

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
	public SampleVO getSampleData(long id) {
		SampleData sampleData = sampleService.getSample(id);
		SampleVO sampleVO = sampleWrapper.wrap(sampleData);
		if (sampleVO != null) {
			return sampleVO;
		} else {
			throw new NotFoundException("没有找到Sample");
		}
	}

	@Override
	public OperationStatus save(String name, String detail) {
		if (sampleService.save(name, detail)) {
			return new OperationStatus(SUCCESS);
		} else {
			return new OperationStatus(FAILURE);
		}
	}

	@Override
	public OperationStatus put(long id, String name, String detail) {
		if (getSampleData(id) == null) {
			throw new NotFoundException("不存在Sample");
		}
		if (sampleService.put(id, name, detail)) {
			return new OperationStatus(SUCCESS);
		} else {
			return new OperationStatus(FAILURE);
		}
	}

	@Override
	public OperationStatus delete(long id) {
		if (getSampleData(id) == null) {
			throw new NotFoundException("不存在Sample");
		}
		if (sampleService.delete(id)) {
			return new OperationStatus(SUCCESS);
		} else {
			return new OperationStatus(FAILURE);
		}
	}
}
