import cn.alandelip.Application;
import cn.alandelip.dao.SampleDao;
import cn.alandelip.model.SampleData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Alan on 2017/3/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DataTest {
    @Autowired
    private SampleDao sampleDao;

    @Test
    public void sampleTest() {
        SampleData data = new SampleData();
        data.setId(1);
        data.setName("sample");
        data.setDetail("sample detail");
        sampleDao.save(data);

        Assert.assertEquals(1, sampleDao.count());
        Assert.assertEquals(1, sampleDao.findByName("sample").getId());
        Assert.assertEquals(1, sampleDao.findByNameAndDetail("sample", "sample detail").getId());
        Assert.assertEquals(1, sampleDao.findSample("sample").getId());

        sampleDao.delete(sampleDao.findByName("sample"));
        Assert.assertEquals(0, sampleDao.count());

    }
}
