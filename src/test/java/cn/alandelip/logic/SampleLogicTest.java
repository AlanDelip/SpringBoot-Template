package cn.alandelip.logic;

import cn.alandelip.entity.SampleData;
import cn.alandelip.exception.InternalServerException;
import cn.alandelip.service.SampleService;
import cn.alandelip.web.model.SampleVO;
import cn.alandelip.web.model.wrapper.SampleWrapper;
import cn.alandelip.exception.NotFoundException;
import cn.alandelip.logic.impl.SampleLogicImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

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
		//no entity is found
		when(sampleService.getSample(1))
				.thenReturn(null);
		try {
			sampleLogic.getSampleData(1);
		} catch (NotFoundException e) {
			assertEquals("sample not found", e.getMessage());
		}

		//entity found
		SampleData sampleData = new SampleData();
		sampleData.setId(2);
		when(sampleService.getSample(2))
				.thenReturn(sampleData);
		SampleVO sampleVO = new SampleVO();
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
	}

	@Test
	public void testPut() {
		//no sample is found
		when(sampleService.getSample(1))
				.thenReturn(null);
		try {
			sampleLogic.put(1, "fail", "fail");
		} catch (NotFoundException e) {
			assertEquals("sample not found", e.getMessage());
		}

		//modify fails
		when(sampleService.put(2, "fail", "fail"))
				.thenReturn(false);
		mockGetSample(2);
		try {
			sampleLogic.put(2, "fail", "fail");
		} catch (InternalServerException e) {
			assertEquals("modify fails", e.getMessage());
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

		//delete fails
		when(sampleService.delete(2))
				.thenReturn(false);
		mockGetSample(2);
		try {
			sampleLogic.delete(2);
		} catch (InternalServerException e) {
			assertEquals("delete fails", e.getMessage());
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
