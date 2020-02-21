package net.coding.apidemo;

import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

//	private static final Logger log = LoggerFactory.getLogger(Application.class);

//	private static volatile Server server;

//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}

	@Bean
	public Docket docket(ServletContext servletContext) {
		ApiSelectorBuilder builder = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.tags(new Tag("宠物", "所有关于宠物的内容"),
						new Tag("会话", "关于用户的注册、登录和登出"))
				.host("petstore.com")
				.pathProvider(new RelativePathProvider(servletContext) {
					@Override
					public String getApplicationBasePath() {
						return "/api/v1";
					}
				})
				.select();

		builder.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class));

		return builder.build()
				.ignoredParameterTypes(RequestAttribute.class)
				.ignoredParameterTypes(Errors.class);
	}

	@Bean
	public JettyServletWebServerFactory jettyEmbeddedServletContainerFactory() {
		log.info("Jetty version: " + Server.getVersion());
//		JettyServletWebServerFactory factory = new JettyServletWebServerFactory();

		int port = 8090;
		factory.setPort(port);
		log.info("Jetty configured on port: " + port);

		log.info("Swagger API: http://127.0.0.1:" + port + "/v2/api-docs");

		return factory;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("宠物商店 API 文档")
				.description("这是一篇关于宠物商店的 DEMO API 文档，仅做参考。")
				.termsOfServiceUrl("http://swagger.io/terms/")
				.contact(new Contact("CODING", "https://coding.net", "support@coding.net"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();
	}
}
