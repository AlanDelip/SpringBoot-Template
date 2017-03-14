package cn.alandelip.web.data.wrapper;

import cn.alandelip.constants.ErrorCode;
import cn.alandelip.dao.SampleDao;
import cn.alandelip.model.SampleData;
import cn.alandelip.web.data.Response;
import cn.alandelip.web.data.SampleVO;
import javassist.tools.reflect.Sample;
import org.springframework.stereotype.Service;

/**
 * @author Alan on 2017/3/14
 */
@Service
public class SampleWrapper {
    public Response<SampleVO> wrap(SampleData sampleData) {
        if (sampleData != null) {
            SampleVO sampleVO = new SampleVO();
            sampleVO.setId(sampleData.getId());
            sampleVO.setName(sampleData.getName());
            return new Response<SampleVO>()
                    .succ()
                    .data(sampleVO);
        } else {
            return new Response<SampleVO>()
                    .fail()
                    .code(ErrorCode.NOT_FOUND);
        }

    }
}
