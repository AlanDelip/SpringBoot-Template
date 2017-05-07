package cn.alandelip.service.impl;

import cn.alandelip.dao.SampleDao;
import cn.alandelip.model.SampleData;
import cn.alandelip.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alan on 2017/3/14
 */
@Service
public class SampleServiceImpl implements SampleService {

	private SampleDao sampleDao;

	@Autowired
	public SampleServiceImpl(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}

	@Override
	public SampleData getSample(long id) {
		return sampleDao.findOne(id);
	}

	@Override
	public Boolean save(String name, String detail) {
		SampleData sampleData = new SampleData();
		sampleData.setName(name);
		sampleData.setDetail(detail);
		return sampleDao.save(sampleData) != null;

	}
}
