package cn.alandelip;

import cn.alandelip.entity.SampleData;
import cn.alandelip.resolver.Mutation;
import cn.alandelip.resolver.Query;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Alan on 2017/3/14
 */
@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Autowired
	public GraphQLSchema graphqlSchema(ConfigurableApplicationContext context) {
		return context.getBean(SchemaParser.class).makeExecutableSchema();
	}

	@Bean
	@Autowired
	public SchemaParser graphqlSchemaParser(ConfigurableApplicationContext context) {
		return SchemaParser.newParser()
				.file("sample.graphqls")
				.dictionary(SampleData.class)
				.resolvers(context.getBean(Query.class), context.getBean(Mutation.class)).build();
	}
}
