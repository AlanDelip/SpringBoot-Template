package cn.alandelip.web.ctrl;

import cn.alandelip.web.data.OperationStatus;
import cn.alandelip.web.data.SampleVO;
import cn.alandelip.web.exception.Error;
import cn.alandelip.web.logic.SampleLogic;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alan on 2017/3/14
 */
@Api(value = "样例Controller", description = "Sample Http API")
@RestController
public class SampleCtrl extends BaseController {

	private SampleLogic sampleLogic;

	@Autowired
	public SampleCtrl(SampleLogic sampleLogic) {
		this.sampleLogic = sampleLogic;
	}


	@ApiOperation(value = "获取Sample", notes = "获取Sample对象", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
			@ApiResponse(code = 404, message = "没有找到Sample", response = Error.class)
	})
	@RequestMapping(value = "/sample/{id:[0-9]*}", method = RequestMethod.GET)
	public SampleVO getSampleData(@PathVariable("id") long id) {
		return sampleLogic.getSampleData(id);
	}


	@ApiOperation(value = "保存Sample", notes = "保存Sample对象", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParam(name = "sampleVO", value = "Sample对象", paramType = "body", required = true, dataType = "SampleVO")
	@RequestMapping(value = "/sample", method = RequestMethod.POST)
	public OperationStatus saveSampleData(@RequestBody SampleVO sampleVO) {
		return sampleLogic.save(sampleVO.getName(), sampleVO.getDetail());
	}


	@ApiOperation(value = "删除Sample", notes = "根据ID删除Sample对象", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
			@ApiResponse(code = 403, message = "没有找到Sample", response = Error.class)
	})
	@RequestMapping(value = "/sample/{id:[0-9]*}", method = RequestMethod.DELETE)
	public OperationStatus deleteSampleData(@PathVariable("id") long id) {
		return sampleLogic.delete(id);
	}


	@ApiOperation(value = "修改Sample", notes = "根据ID修改Sample对象", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParam(name = "sampleVO", value = "Sample对象", paramType = "body", required = true, dataType = "SampleVO")
	@ApiResponses({
			@ApiResponse(code = 403, message = "没有找到Sample", response = Error.class)
	})
	@RequestMapping(value = "/sample", method = RequestMethod.PUT)
	public OperationStatus putSampleData(@RequestBody SampleVO sampleVO) {
		return sampleLogic.put(sampleVO.getId(), sampleVO.getName(), sampleVO.getDetail());
	}
}
