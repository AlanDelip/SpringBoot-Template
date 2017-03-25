package cn.alandelip.web.data.wrapper;

import cn.alandelip.constants.ErrorCode;
import cn.alandelip.dao.SampleDao;
import cn.alandelip.model.Point;
import cn.alandelip.model.Route;
import cn.alandelip.model.SampleData;
import cn.alandelip.web.data.HeatMapVO;
import cn.alandelip.web.data.Response;
import cn.alandelip.web.data.RouteVO;
import cn.alandelip.web.data.SampleVO;
import javassist.tools.reflect.Sample;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Response<List<HeatMapVO>> wrap(List<Point> pointList) {
        List<HeatMapVO> heatMapVOList = new ArrayList<>();
        for (Point point : pointList) {
            double x = Math.rint(point.getX() / 10);
            double y = Math.rint(point.getY() / 10);
            boolean isIn = false;
            for (HeatMapVO heatMapVO : heatMapVOList) {
                if (x == heatMapVO.getX() && y == heatMapVO.getY()) {
                    heatMapVO.setWeight(heatMapVO.getWeight() + 1);
                    isIn = true;
                    break;
                }
            }
            if (!isIn) {
                HeatMapVO heatMapVO = new HeatMapVO();
                heatMapVO.setX(x);
                heatMapVO.setY(y);
                heatMapVO.setWeight(1);
                heatMapVOList.add(heatMapVO);
            }
        }
        return new Response<List<HeatMapVO>>()
                .succ()
                .data(heatMapVOList);
    }

    public Response<List<RouteVO>> wrapRoute(List<Route> routeList) {
        List<RouteVO> identicalRouteList = new ArrayList<>();
        List<RouteVO> allRouteList = new ArrayList<>();
        Map<String, Integer> routeValueMap = new HashMap<>();
        for (Route route : routeList) {
            String[] routeSplit = route.getRoute().split(",");
            for (int i = 0; i < routeSplit.length; i++) {
                String source = routeSplit[i];
                String target = "";
                if (i + 1 < routeSplit.length) {
                    target = routeSplit[i + 1];
                }
                RouteVO routeVO = new RouteVO();
                routeVO.setSource(source);
                routeVO.setTarget(target);
                allRouteList.add(routeVO);
            }
        }
        for (RouteVO routeVO : allRouteList) {
            if (!routeVO.getTarget().equals("")) {
                String route = routeVO.getSource() + "_" + routeVO.getTarget();
                //如果没有该路径就初始化
                Integer currentValue = routeValueMap.putIfAbsent(route, 1);
                //否则在原有基础上设置value + 1
                if (currentValue != null) {
                    routeValueMap.replace(route, currentValue + 1);
                }
            }
        }
        for (String routeStr : routeValueMap.keySet()) {
            String source = routeStr.split("_")[0];
            String target = routeStr.split("_")[1];
            int value = routeValueMap.get(routeStr);
            RouteVO routeVO = new RouteVO();
            routeVO.setSource(source);
            routeVO.setTarget(target);
            routeVO.setValue(value);
            identicalRouteList.add(routeVO);
        }
        return new Response<List<RouteVO>>()
                .succ()
                .data(identicalRouteList);
    }
}
