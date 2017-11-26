package orca.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class WebConfiguration {
    
    @Bean
    public Docket greetApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("insurance")
                .apiInfo(greetapiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("failsafe.orca.rest"))
                //.paths(regex("/greeting.*"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
     
    private ApiInfo greetapiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger REST")
                .description("Swagger api docs")
                .contact("Prem Natarajan")
                .version("1.0")
                .build();
    }
}
