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

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private static volatile Server server;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public JettyServletWebServerFactory jettyEmbeddedServletContainerFactory() {
		log.info("Jetty version: " + Server.getVersion());
		JettyServletWebServerFactory factory = new JettyServletWebServerFactory();

		int port = 8090;
		factory.setPort(port);
		log.info("Jetty configured on port: " + port);

		log.info("Swagger API: http://127.0.0.1:" + port + "/v2/api-docs");

		return factory;
	}
}
