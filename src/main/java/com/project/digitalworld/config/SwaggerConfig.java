package com.project.digitalworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
   @Bean
   public Docket apiDocket() {
       
       Docket docket =  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.project.digitalworld"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails());
       
       return docket;
    } 
   
   private ApiInfo apiDetails() {
	   return new ApiInfo("Digital World API",
	              "Api for Digital World project",
	              "V1",
	              "NA terms of service url",
	              null,
	              null,
	              "NA");
   }
}