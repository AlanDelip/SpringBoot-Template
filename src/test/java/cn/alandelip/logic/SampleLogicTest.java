package cn.alandelip.logic;

import cn.alandelip.entity.SampleData;
import cn.alandelip.service.SampleService;
import cn.alandelip.web.model.OperationStatus;
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
		//没有找到实例
		when(sampleService.getSample(1))
				.thenReturn(null);
		try {
			sampleLogic.getSampleData(1);
		} catch (NotFoundException e) {
			assertEquals("没有找到Sample", e.getMessage());
		}

		//找到实例
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
		//save失败
		when(sampleService.save("fail", "fail"))
				.thenReturn(false);
		sampleLogic.save("fail", "fail");
//        assertEquals("failure", failStatus.getStatus());

		//save成功
		when(sampleService.save("success", "success"))
				.thenReturn(true);
		sampleLogic.save("success", "success");
//        assertEquals("success", successStatus.getStatus());
	}

	@Test
	public void testPut() {
		//没有找到Sample
		when(sampleService.getSample(1))
				.thenReturn(null);
		try {
			sampleLogic.put(1, "fail", "fail");
		} catch (NotFoundException e) {
			assertEquals("没有找到Sample", e.getMessage());
		}

		//没有修改成功
		when(sampleService.put(2, "fail", "fail"))
				.thenReturn(false);
		mockGetSample(2);
		sampleLogic.put(2, "fail", "fail");
//        assertEquals("failure", failStatus.getStatus());

		//修改成功
		when(sampleService.put(2, "success", "success"))
				.thenReturn(true);
		sampleLogic.put(2, "success", "success");
//        assertEquals("success", successStatus.getStatus());
	}

	@Test
	public void testDelete() {
		//没有找到Sample
		when(sampleService.getSample(1))
				.thenReturn(null);
		try {
			sampleLogic.delete(1);
		} catch (NotFoundException e) {
			assertEquals("没有找到Sample", e.getMessage());
		}

		//删除失败
		when(sampleService.delete(2))
				.thenReturn(false);
		mockGetSample(2);
		sampleLogic.delete(2);
//		assertEquals("failure", failStatus.getStatus());

		//删除成功
		when(sampleService.delete(3))
				.thenReturn(true);
		mockGetSample(3);
		sampleLogic.delete(3);
//		assertEquals("success", successStatus.getStatus());
	}

	private void mockGetSample(long id) {
		SampleData sampleData = new SampleData();
		when(sampleService.getSample(id))
				.thenReturn(sampleData);
		when(sampleWrapper.wrap(sampleData))
				.thenReturn(new SampleVO());
	}
}
