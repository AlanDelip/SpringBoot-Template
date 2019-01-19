package cn.alandelip.resolver;

import cn.alandelip.entity.SampleData;
import cn.alandelip.logic.SampleLogic;
import cn.alandelip.repository.SampleDao;
import cn.alandelip.service.SampleService;
import cn.alandelip.web.model.SampleVO;
import cn.alandelip.web.model.wrapper.SampleWrapper;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Query Resolver for GraphQL
 *
 * @author Alan on 01/18/19
 */
@Component
public class Query implements GraphQLQueryResolver {

	private SampleService sampleService;
	private SampleDao sampleRepo;

	@Autowired
	public Query(SampleService sampleService, SampleDao sampleRepo) {
		this.sampleRepo = sampleRepo;
		this.sampleService = sampleService;
	}

	public SampleData findSampleById(long id) {
		return sampleService.getSample(id);
	}

	public List<SampleData> findAllSamples() {
		return sampleService.getSamples();
	}
}
