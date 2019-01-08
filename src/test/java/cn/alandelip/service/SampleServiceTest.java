package cn.alandelip.service;

import cn.alandelip.entity.SampleData;
import cn.alandelip.repository.SampleDao;
import cn.alandelip.service.impl.SampleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Alan on 2017/6/7
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@SpringBootTest
public class SampleServiceTest {
	@Mock
	private SampleDao sampleDao;

	@InjectMocks
	private SampleService sampleService = new SampleServiceImpl(sampleDao);

	@Before
	public void setUp() throws Exception {
		initMocks(this);
	}

	@Test
	public void testGetSample() {
		//list samples
		SampleData sampleData = new SampleData();
		sampleData.setId(2);
		List<SampleData> samples = new ArrayList<>();
		samples.add(sampleData);
		when(sampleDao.findAll()).thenReturn(samples);
		assertEquals(samples, sampleService.getSamples());

		//sample not found
		when(sampleDao.getOne(Long.valueOf("1")))
				.thenReturn(null);
		assertNull(sampleService.getSample(1));

		//sample is found

		when(sampleDao.getOne(Long.valueOf("2")))
				.thenReturn(sampleData);
		assertEquals(sampleData.getId(), sampleService.getSample(2).getId());
	}

	@Test
	public void testSave() {
		//save fail
		assertFalse(sampleService.save("fail", "fail"));

		//save success
		stub(sampleDao.save(any(SampleData.class)))
				.toReturn(new SampleData());
		assertTrue(sampleService.save("success", "success"));
	}

	@Test
	public void testPut() {
		//sample not found
		assertFalse(sampleService.put(1, "fail", "fail"));

		//sample is found
		SampleData successData = new SampleData();
		when(sampleDao.getOne(Long.valueOf("2")))
				.thenReturn(successData);
		when(sampleDao.save(successData))
				.thenReturn(new SampleData());
		assertTrue(sampleService.put(2, "success", "success"));

		//modify fail
		SampleData failData = new SampleData();
		when(sampleDao.getOne(Long.valueOf("3")))
				.thenReturn(failData);
		assertFalse(sampleService.put(3, "fail", "fail"));

		//modify success
		when(sampleDao.getOne(Long.valueOf("4")))
				.thenReturn(successData);
		when(sampleDao.save(successData))
				.thenReturn(new SampleData());
		assertTrue(sampleService.put(4, "success", "success"));
	}

	@Test
	public void testDelete() {
		assertTrue(sampleService.delete(1));
	}
}
