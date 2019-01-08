package cn.alandelip.web.ctrl;

import cn.alandelip.logic.SampleLogic;
import cn.alandelip.web.model.SampleVO;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller, handling CURD(create, update, read, delete) operations.
 *
 * @author Alan on 2017/3/14
 */
@Api(value = "sample controller", description = "Sample Http API", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "sample")
@RestController
@Log4j2
public class SampleCtrl {

	private SampleLogic sampleLogic;

	@Autowired
	public SampleCtrl(SampleLogic sampleLogic) {
		this.sampleLogic = sampleLogic;
	}

	@ApiOperation(value = "get all samples", notes = "get all sample objects")
	@RequestMapping(method = RequestMethod.GET)
	public List<SampleVO> getSamples() {
		return sampleLogic.getSamples();
	}

	@ApiOperation(value = "get sample", notes = "get a sample object")
	@ApiResponses({
			@ApiResponse(code = 404, message = "sample not found")
	})
	@RequestMapping(value = "{id:[0-9]*}", method = RequestMethod.GET)
	public SampleVO getSampleData(@PathVariable long id) {
		return sampleLogic.getSampleData(id);
	}


	@ApiOperation(value = "save sample", notes = "save a sample object")
	@ApiImplicitParam(name = "sampleVO", value = "sample object", paramType = "body", required = true, dataType = "SampleVO")
	@RequestMapping(method = RequestMethod.POST)
	public void saveSampleData(@RequestBody SampleVO sampleVO) {
		sampleLogic.save(sampleVO.getName(), sampleVO.getDetail());
	}


	@ApiOperation(value = "delete sample", notes = "delete sample object by id")
	@ApiResponses({
			@ApiResponse(code = 403, message = "sample not found")
	})
	@RequestMapping(value = "{id:[0-9]*}", method = RequestMethod.DELETE)
	public void deleteSampleData(@PathVariable long id) {
		sampleLogic.delete(id);
	}


	@ApiOperation(value = "modify sample", notes = "modify sample object by id", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParam(name = "sampleVO", value = "sample object", paramType = "body", required = true, dataType = "SampleVO")
	@ApiResponses({
			@ApiResponse(code = 403, message = "sample not found")
	})
	@RequestMapping(method = RequestMethod.PUT)
	public void putSampleData(@RequestBody SampleVO sampleVO) {
		sampleLogic.put(sampleVO);
	}
}
