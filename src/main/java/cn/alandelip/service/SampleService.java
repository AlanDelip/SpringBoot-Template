package cn.alandelip.service;

import cn.alandelip.model.Point;
import cn.alandelip.model.Route;
import cn.alandelip.model.SampleData;

import java.util.List;

/**
 * @author Alan on 2017/3/14
 */
public interface SampleService {
    SampleData getSample(long id);

    Boolean save(String name, String detail);

    Boolean savePoints(List<Double> x, List<Double> y);

    List<Point> getPoints();

    Boolean saveRoute(String routeList);

    List<Route> getRoute();
}
