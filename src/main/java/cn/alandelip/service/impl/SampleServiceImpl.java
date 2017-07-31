package cn.alandelip.service.impl;

import cn.alandelip.dao.SampleDao;
import cn.alandelip.model.SampleData;
import cn.alandelip.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public Boolean put(long id, String name, String detail) {
		SampleData sampleData = sampleDao.findOne(id);
		if (sampleData != null) {
			sampleData.setName(name);
			sampleData.setDetail(detail);
			return sampleDao.save(sampleData) != null;
		} else {
			return false;
		}
	}

	@Override
	public Boolean delete(long id) {
		sampleDao.delete(id);
		return true;
	}

	@Override
	public List<SampleData> getSamples() {
		return null;
	}
}
