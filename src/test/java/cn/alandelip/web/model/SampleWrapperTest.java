package cn.alandelip.web.model;

import cn.alandelip.entity.SampleData;
import cn.alandelip.web.model.wrapper.SampleWrapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Alan on 2017/6/7
 */
public class SampleWrapperTest {
	@Test
	public void testWrap() {
		//输入为null
		SampleWrapper sampleWrapper = new SampleWrapper();
		SampleVO nullSample = sampleWrapper.wrap(null);
		assertNull(nullSample);

		//输入不为空
		SampleData sampleData = new SampleData();
		sampleData.setId(1);
		SampleVO sampleVO = sampleWrapper.wrap(sampleData);
		assertEquals(sampleData.getId(), sampleVO.getId());
	}
}

