package cn.alandelip.service.impl;

import cn.alandelip.entity.SampleData;
import cn.alandelip.repository.SampleDao;
import cn.alandelip.service.SampleService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alan on 2017/3/14
 */
@Service
@Log4j2
public class SampleServiceImpl implements SampleService {

	private SampleDao sampleDao;

	@Autowired
	public SampleServiceImpl(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}

	@Override
	public SampleData getSample(long id) {
		return sampleDao.getOne(id);
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
		SampleData sampleData = sampleDao.getOne(id);
		if (sampleData != null) {
			sampleData.setName(name);
			sampleData.setDetail(detail);
			return sampleDao.save(sampleData) != null;
		}
		return false;
	}

	@Override
	public Boolean delete(long id) {
		sampleDao.deleteById(id);
		return true;
	}

	@Override
	public List<SampleData> getSamples() {
		return sampleDao.findAll();
	}
}
