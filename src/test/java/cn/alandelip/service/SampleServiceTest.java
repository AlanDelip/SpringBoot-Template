package cn.alandelip.service;

import cn.alandelip.dao.SampleDao;
import cn.alandelip.model.SampleData;
import cn.alandelip.service.impl.SampleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

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
		//没有找到Sample
		when(sampleDao.findOne(Long.valueOf("1")))
				.thenReturn(null);
		assertNull(sampleService.getSample(1));

		//找到Sample
		SampleData sampleData = new SampleData();
		sampleData.setId(1);
		when(sampleDao.findOne(Long.valueOf("2")))
				.thenReturn(sampleData);
		assertEquals(sampleData.getId(), sampleService.getSample(2).getId());
	}

	@Test
	public void testSave() {
		//save失败
		assertFalse(sampleService.save("fail", "fail"));

		//save成功
		stub(sampleDao.save(any(SampleData.class)))
				.toReturn(new SampleData());
		assertTrue(sampleService.save("success", "success"));
	}

	@Test
	public void testPut() {
		//没有找到Sample
		assertFalse(sampleService.put(1, "fail", "fail"));

		//修改失败
		SampleData failData = new SampleData();
		when(sampleDao.findOne(Long.valueOf("2")))
				.thenReturn(failData);
		assertFalse(sampleService.put(2, "fail", "fail"));

		//修改成功
		SampleData successData = new SampleData();
		when(sampleDao.findOne(Long.valueOf("3")))
				.thenReturn(successData);
		when(sampleDao.save(successData))
				.thenReturn(new SampleData());
		assertTrue(sampleService.put(3, "success", "success"));
	}

	@Test
	public void testDelete() {
		assertTrue(sampleService.delete(1));
	}
}
