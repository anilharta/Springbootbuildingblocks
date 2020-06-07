package com.java.RestServices.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/*
 * Swagger Metadata : http://localhost:9090/v2/api-docs
 * Swagger URI : http://localhost:9090/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.java.RestServices"))
				.paths(PathSelectors.ant("/usersr/**"))
				.build();
	     }
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()				
				.title("User Management Service")
				.description("This page lists all API's of User Management")
				.version("2.0")
				.contact(new Contact("aharta", "https://www.abc.com", "abcy@gmail.com"))
				.license("License 2.0")
				.licenseUrl("https://www.abc.com/license.html")
				.build();
	}
   }
	

