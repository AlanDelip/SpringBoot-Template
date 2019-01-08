package cn.alandelip.web.model;

import cn.alandelip.entity.SampleData;
import cn.alandelip.exception.TransformException;
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
		//null input
		SampleWrapper sampleWrapper = new SampleWrapper();
		try {
			sampleWrapper.wrap(null);
		} catch (TransformException e) {
			assertEquals("wrap fails", e.getMessage());
		}

		//valid input
		SampleData sampleData = new SampleData();
		sampleData.setId(1);
		SampleVO sampleVO = sampleWrapper.wrap(sampleData);
		assertEquals(sampleData.getId(), sampleVO.getId());
	}

	@Test
	public void testUnwrap() {
		//null input
		SampleWrapper sampleWrapper = new SampleWrapper();
		try {
			sampleWrapper.unwrap(null);
		} catch (TransformException e) {
			assertEquals("unwrap fails", e.getMessage());
		}

		//valid input
		SampleVO sampleVO = new SampleVO();
		sampleVO.setId(1);
		SampleData sampleData = sampleWrapper.unwrap(sampleVO);
		assertEquals(sampleVO.getId(), sampleData.getId());
	}
}

