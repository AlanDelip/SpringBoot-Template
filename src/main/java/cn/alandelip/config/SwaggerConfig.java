package cn.alandelip.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

/**
 * @author Alan on 2017/6/6
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${swagger.api-version}")
	private String version;

	@Value("${swagger.title}")
	private String title;

	@Value("${swagger.description}")
	private String description;

	@Value("${swagger.license}")
	private String license;

	@Value("${swagger.license-url}")
	private String licenseUrl;

	@Value("${swagger.contact.name}")
	private String contactName;

	@Value("${swagger.contact.email}")
	private String contactEmail;

	@Value("${swagger.contact.homepage}")
	private String contactHomepage;

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.contact(new Contact(contactName, contactHomepage, contactEmail))
				.license(license)
				.licenseUrl(licenseUrl)
				.version(version)
				.build();
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(withClassAnnotation(RestController.class))
				.build()
				.apiInfo(apiInfo())
				.ignoredParameterTypes(
						HttpServletRequest.class,
						HttpServletResponse.class,
						HttpSession.class,
						Pageable.class,
						Errors.class
				);
	}
}
