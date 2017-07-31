package cn.alandelip.web.ctrl;

import cn.alandelip.web.data.OperationStatus;
import cn.alandelip.web.data.SampleVO;
import cn.alandelip.web.exception.Error;
import cn.alandelip.web.logic.SampleLogic;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alan on 2017/3/14
 */
@Api(value = "sample controller", description = "Sample Http API")
@RequestMapping(value = "sample")
@RestController
public class SampleCtrl extends BaseController {

	private SampleLogic sampleLogic;

	@Autowired
	public SampleCtrl(SampleLogic sampleLogic) {
		this.sampleLogic = sampleLogic;
	}

	@ApiOperation(value = "get all samples", notes = "get all sample objects", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(method = RequestMethod.GET)
	public List<SampleVO> getSamples() {
		return sampleLogic.getSamples();
	}

	@ApiOperation(value = "get sample", notes = "get a sample object", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
			@ApiResponse(code = 404, message = "sample not found", response = Error.class)
	})
	@RequestMapping(value = "{id:[0-9]*}", method = RequestMethod.GET)
	public SampleVO getSampleData(@PathVariable long id) {
		return sampleLogic.getSampleData(id);
	}


	@ApiOperation(value = "save sample", notes = "save a sample object", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParam(name = "sampleVO", value = "sample object", paramType = "body", required = true, dataType = "SampleVO")
	@RequestMapping(method = RequestMethod.POST)
	public OperationStatus saveSampleData(@RequestBody SampleVO sampleVO) {
		return sampleLogic.save(sampleVO.getName(), sampleVO.getDetail());
	}


	@ApiOperation(value = "delete sample", notes = "delete sample object by id", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
			@ApiResponse(code = 403, message = "sample not found", response = Error.class)
	})
	@RequestMapping(value = "{id:[0-9]*}", method = RequestMethod.DELETE)
	public OperationStatus deleteSampleData(@PathVariable long id) {
		return sampleLogic.delete(id);
	}


	@ApiOperation(value = "modify sample", notes = "modify sample object by id", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParam(name = "sampleVO", value = "sample object", paramType = "body", required = true, dataType = "SampleVO")
	@ApiResponses({
			@ApiResponse(code = 403, message = "sample not found", response = Error.class)
	})
	@RequestMapping(method = RequestMethod.PUT)
	public OperationStatus putSampleData(@RequestBody SampleVO sampleVO) {
		return sampleLogic.put(sampleVO.getId(), sampleVO.getName(), sampleVO.getDetail());
	}
}
