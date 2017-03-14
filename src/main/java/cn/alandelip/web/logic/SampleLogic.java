package cn.alandelip.web.logic;

import cn.alandelip.model.SampleData;
import cn.alandelip.web.data.Response;
import cn.alandelip.web.data.SampleVO;

/**
 * @author Alan on 2017/3/14
 */
public interface SampleLogic {
    Response<SampleVO> getSampleData(long id);

    Response save(String name, String detail);
}
