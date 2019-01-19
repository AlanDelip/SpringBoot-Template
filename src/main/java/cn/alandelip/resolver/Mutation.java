package cn.alandelip.resolver;

import cn.alandelip.entity.SampleData;
import cn.alandelip.repository.SampleDao;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mutation Resolver for GraphQL
 *
 * @author Alan on 01/18/19
 */
@Component
public class Mutation implements GraphQLMutationResolver {

	private SampleDao sampleRepo;

	@Autowired
	public Mutation(SampleDao sampleRepo) {
		this.sampleRepo = sampleRepo;
	}

	SampleData createSample(String name, String detail) {
		SampleData sampleData = new SampleData();
		sampleData.setName(name);
		sampleData.setDetail(detail);
		return sampleRepo.save(sampleData);
	}

	Boolean deleteSample(long id) {
		sampleRepo.deleteById(id);
		return true;
	}
}
