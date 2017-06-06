package cn.alandelip.web.ctrl;

import cn.alandelip.web.logic.SampleLogic;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Alan on 2017/6/6
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@SpringBootTest
public class SampleCtrlTest {
	private static final String SAMPLE_MAPPING = "/sample";
	private MockMvc mockMvc;

	@Mock
	private SampleLogic sampleLogic;

	@InjectMocks
	private SampleCtrl sampleCtrl = new SampleCtrl(sampleLogic);

	@Before
	public void setupMockMvc() {
		initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(sampleCtrl).build();
	}

	@Test
	public void testGetSample() throws Exception {
		mockMvc.perform(
				get(SAMPLE_MAPPING + "/1"))
				.andExpect(status().isOk());
	}
}
