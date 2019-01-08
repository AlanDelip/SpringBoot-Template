package cn.alandelip.web.ctrl;

import cn.alandelip.web.model.SampleVO;
import cn.alandelip.logic.SampleLogic;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

	@Test
	public void testGetSamples() throws Exception {
		mockMvc.perform(
				get(SAMPLE_MAPPING))
				.andExpect(status().isOk());
	}

	@Test
	public void testPostSample() throws Exception {
		mockMvc.perform(
				post(SAMPLE_MAPPING)
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(new SampleVO())))
				.andExpect(status().isOk());
	}

	@Test
	public void testPutSample() throws Exception {
		mockMvc.perform(
				put(SAMPLE_MAPPING)
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(new SampleVO())))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeleteSample() throws Exception {
		mockMvc.perform(
				delete(SAMPLE_MAPPING + "/1"))
				.andExpect(status().isOk());
	}
}
