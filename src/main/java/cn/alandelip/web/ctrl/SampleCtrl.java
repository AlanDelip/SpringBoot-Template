package cn.alandelip.web.ctrl;

import cn.alandelip.model.SampleData;
import cn.alandelip.service.SampleService;
import cn.alandelip.web.data.Response;
import cn.alandelip.web.data.SampleVO;
import cn.alandelip.web.logic.SampleLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alan on 2017/3/14
 */
@RestController
public class SampleCtrl {

    private SampleLogic sampleLogic;

    @Autowired
    public SampleCtrl(SampleLogic sampleLogic) {
        this.sampleLogic = sampleLogic;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(@RequestParam(name = "name", defaultValue = "SpringBoot") String name) {
        return "Hello, " + name + "!";
    }

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public Response<SampleVO> getSampleDataByParam(@RequestParam(name = "id") long id) {
        return sampleLogic.getSampleData(id);
    }

    @RequestMapping(value = "/sample/{id:[0-9]*}", method = RequestMethod.GET)
    public Response<SampleVO> getSampleDataByRoute(@PathVariable("id") long id) {
        return sampleLogic.getSampleData(id);
    }

    @RequestMapping(value = "/sample", method = RequestMethod.POST)
    public Response saveSampleData(@RequestParam(name = "name") String name,
                                   @RequestParam(name = "detail") String detail) {
        return sampleLogic.save(name, detail);
    }

    @RequestMapping(value = "/point", method = RequestMethod.POST)
    public Response savePoints(@RequestParam(name = "x") List<Double> x,
                               @RequestParam(name = "y") List<Double> y) {
        return sampleLogic.savePoints(x, y);
    }

    @RequestMapping(value = "/point", method = RequestMethod.GET)
    public Response getPoints() {
        return sampleLogic.getPoints();
    }

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    public Response saveRoute(@RequestParam(name = "route") String routeList) {
        return sampleLogic.saveRoute(routeList);
    }

    @RequestMapping(value = "/route", method = RequestMethod.GET)
    public Response getRoute() {
        return sampleLogic.getRoute();
    }
}
