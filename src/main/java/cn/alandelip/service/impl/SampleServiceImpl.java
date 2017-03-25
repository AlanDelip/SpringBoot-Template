package cn.alandelip.service.impl;

import cn.alandelip.dao.PointDao;
import cn.alandelip.dao.RouteDao;
import cn.alandelip.dao.SampleDao;
import cn.alandelip.model.Point;
import cn.alandelip.model.Route;
import cn.alandelip.model.SampleData;
import cn.alandelip.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alan on 2017/3/14
 */
@Service
public class SampleServiceImpl implements SampleService {

    private SampleDao sampleDao;
    private PointDao pointDao;
    private RouteDao routeDao;

    @Autowired
    public SampleServiceImpl(SampleDao sampleDao, PointDao pointDao, RouteDao routeDao) {
        this.sampleDao = sampleDao;
        this.pointDao = pointDao;
        this.routeDao = routeDao;
    }

    @Override
    public SampleData getSample(long id) {
        return sampleDao.findOne(id);
    }

    @Override
    public Boolean save(String name, String detail) {
        SampleData sampleData = new SampleData();
        sampleData.setName(name);
        sampleData.setDetail(detail);
        return sampleDao.save(sampleData) != null;

    }

    @Override
    public Boolean savePoints(List<Double> x, List<Double> y) {
        if (x.size() != y.size()) {
            return false;
        } else {
            for (int i = 0; i < x.size(); i++) {
                Point point = new Point();
                point.setX(x.get(i));
                point.setY(y.get(i));
                pointDao.save(point);
            }
        }
        return true;
    }

    @Override
    public List<Point> getPoints() {
        return pointDao.findAll();
    }

    @Override
    public Boolean saveRoute(String routeList) {
        Route route = new Route();
        route.setRoute(routeList);
        return routeDao.save(route) != null;
    }

    @Override
    public List<Route> getRoute() {
        return routeDao.findAll();
    }
}
