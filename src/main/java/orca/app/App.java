package orca.app;

import static springfox.documentation.builders.PathSelectors.regex;

//import org.springframework.boot.autoconfigure.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication//(exclude = MessageSourceAutoConfiguration.class)
@EnableSwagger2
public class App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }
    
    
    @Bean
    public Docket greetApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("insurance")
                .apiInfo(greetapiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("orca.app.rest"))
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

