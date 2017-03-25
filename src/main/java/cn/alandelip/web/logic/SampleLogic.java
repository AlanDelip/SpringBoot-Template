package cn.alandelip.web.logic;

import cn.alandelip.model.SampleData;
import cn.alandelip.web.data.Response;
import cn.alandelip.web.data.SampleVO;

import java.util.List;

/**
 * @author Alan on 2017/3/14
 */
public interface SampleLogic {
    Response<SampleVO> getSampleData(long id);

    Response save(String name, String detail);

    Response savePoints(List<Double> x, List<Double> y);

    Response getPoints();

    Response saveRoute(String routeList);

    Response getRoute();
}
