package cn.alandelip.logic;

import cn.alandelip.entity.SampleData;
import cn.alandelip.exception.InternalServerException;
import cn.alandelip.service.SampleService;
import cn.alandelip.web.model.SampleVO;
import cn.alandelip.web.model.wrapper.SampleWrapper;
import cn.alandelip.exception.NotFoundException;
import cn.alandelip.logic.impl.SampleLogicImpl;
import org.junit.Assert;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Alan on 2017/6/7
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@SpringBootTest
public class SampleLogicTest {

	@Mock
	private SampleService sampleService;

	@Mock
	private SampleWrapper sampleWrapper;

	@InjectMocks
	private SampleLogic sampleLogic = new SampleLogicImpl(sampleService, sampleWrapper);

	@Before
	public void setupMockMvc() {
		initMocks(this);
	}

	@Test
	public void testGetSampleData() {
		//list entities
		SampleData sampleData = new SampleData();
		sampleData.setId(1);
		List<SampleData> samples = new ArrayList<>();
		samples.add(sampleData);
		when(sampleService.getSamples()).thenReturn(samples);

		SampleVO sampleVO = new SampleVO();
		sampleVO.setId(1);
		when(sampleWrapper.wrap(sampleData)).thenReturn(sampleVO);
		List<SampleVO> sampleVOs = new ArrayList<>();
		sampleVOs.add(sampleVO);

		assertEquals(sampleVOs, sampleLogic.getSamples());

		//no entity is found
		when(sampleService.getSample(1))
				.thenReturn(null);
		try {
			sampleLogic.getSampleData(1);
		} catch (NotFoundException e) {
			assertEquals("sample not found", e.getMessage());
		}

		//entity found
		when(sampleService.getSample(2))
				.thenReturn(sampleData);
		sampleVO.setId(sampleData.getId());
		when(sampleWrapper.wrap(sampleData))
				.thenReturn(sampleVO);
		SampleVO resultSampleVO = sampleLogic.getSampleData(2);
		assertEquals(sampleData.getId(), resultSampleVO.getId());

	}

	@Test
	public void testSave() {
		//save fails
		when(sampleService.save("fail", "fail"))
				.thenReturn(false);
		try {
			sampleLogic.save("fail", "fail");
		} catch (InternalServerException e) {
			assertEquals("save fails", e.getMessage());
		}

		//save success
		when(sampleService.save("success", "success"))
				.thenReturn(true);
		try {
			sampleLogic.save("success", "success");
		} catch (InternalServerException e) {
			Assert.fail("shouldn't contain exception");
		}
	}

	@Test
	public void testPut() {
		SampleVO sampleVO = new SampleVO();
		sampleVO.setId(1);

		//no sample is found
		when(sampleService.getSample(1))
				.thenReturn(null);
		when(sampleWrapper.unwrap(sampleVO))
				.thenReturn(new SampleData());
		try {
			sampleLogic.put(sampleVO);
		} catch (NotFoundException e) {
			assertEquals("sample not found", e.getMessage());
		}

		//sample is found
		SampleData sampleData = new SampleData();
		sampleData.setId(2);
		when(sampleWrapper.unwrap(sampleVO))
				.thenReturn(sampleData);
		when(sampleService.put(2, null, null))
				.thenReturn(true);
		sampleVO.setId(2);
		mockGetSample(2);
		try {
			sampleLogic.put(sampleVO);
		} catch (NotFoundException e) {
			Assert.fail("shouldn't contain exception");
		}

		//modify fails
		when(sampleService.put(3, "fail", "fail"))
				.thenReturn(false);
		sampleVO.setId(3);
		mockGetSample(3);
		try {
			sampleLogic.put(sampleVO);
		} catch (InternalServerException e) {
			assertEquals("modify fails", e.getMessage());
		}

		//modify success
		when(sampleService.put(4, "success", "success"))
				.thenReturn(true);
		sampleVO.setId(4);
		mockGetSample(4);
		try {
			sampleLogic.put(sampleVO);
		} catch (InternalServerException e) {
			Assert.fail("shouldn't contain exception");
		}
	}

	@Test
	public void testDelete() {
		//no sample is found
		when(sampleService.getSample(1))
				.thenReturn(null);
		try {
			sampleLogic.delete(1);
		} catch (NotFoundException e) {
			assertEquals("sample not found", e.getMessage());
		}

		//sample is found
		when(sampleService.delete(2)).thenReturn(true);
		mockGetSample(2);
		try {
			sampleLogic.delete(2);
		} catch (NotFoundException e) {
			Assert.fail("shouldn't contain exception");
		}

		//delete fails
		when(sampleService.delete(2))
				.thenReturn(false);
		mockGetSample(2);
		try {
			sampleLogic.delete(2);
		} catch (InternalServerException e) {
			assertEquals("delete fails", e.getMessage());
		}

		//delete success
		when(sampleService.delete(4)).thenReturn(true);
		mockGetSample(4);
		try {
			sampleLogic.delete(4);
		} catch (NotFoundException e) {
			Assert.fail("shouldn't contain exception");
		}
	}

	private void mockGetSample(long id) {
		SampleData sampleData = new SampleData();
		when(sampleService.getSample(id))
				.thenReturn(sampleData);
		when(sampleWrapper.wrap(sampleData))
				.thenReturn(new SampleVO());
	}
}
