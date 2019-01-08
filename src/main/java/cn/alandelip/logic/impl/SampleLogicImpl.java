package cn.alandelip.logic.impl;

import cn.alandelip.entity.SampleData;
import cn.alandelip.exception.InternalServerException;
import cn.alandelip.logic.SampleLogic;
import cn.alandelip.service.SampleService;
import cn.alandelip.web.model.SampleVO;
import cn.alandelip.exception.NotFoundException;
import cn.alandelip.web.model.wrapper.SampleWrapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alan on 2017/3/14
 */
@Service
@Log4j2
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
			throw new NotFoundException("sample not found");
		}
	}

	@Override
	public void save(String name, String detail) {
		if (!sampleService.save(name, detail)) {
			throw new InternalServerException("save fails");
		}
	}

	@Override
	public void put(SampleVO sampleVO) {
		SampleData sampleData = sampleWrapper.unwrap(sampleVO);
		if (getSampleData(sampleData.getId()) == null) {
			throw new NotFoundException("sample not exist");
		}
		if (!sampleService.put(sampleData.getId(), sampleData.getName(), sampleData.getDetail())) {
			throw new InternalServerException("modify fails");
		}
	}

	@Override
	public void delete(long id) {
		if (getSampleData(id) == null) {
			throw new NotFoundException("sample not exist");
		}
		if (!sampleService.delete(id)) {
			throw new InternalServerException("delete fails");
		}
	}

	@Override
	public List<SampleVO> getSamples() {
		return sampleService.getSamples().stream()
				.map(sampleWrapper::wrap)
				.collect(Collectors.toList());
	}
}
