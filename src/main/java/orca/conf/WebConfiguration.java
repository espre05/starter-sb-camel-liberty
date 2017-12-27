package orca.conf;

import static com.google.common.collect.Lists.newArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ws.client.core.WebServiceTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
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
                
                .select()
                //.apis(RequestHandlerSelectors.basePackage("failsafe.orca.rest"))
                //.paths(regex("/greeting.*"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(greetapiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build(), new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()));
        
    }
     
    private ApiInfo greetapiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger REST")
                .description("Swagger api docs")
                .contact("Prem Natarajan")
                .version("1.0")
                .build();
    }
    
    @Value("${}")
    private String wsUrl;// for consumin a remote ws endpoint
    @Bean
    public WebServiceTemplate ws() {
        WebServiceTemplate ws = new WebServiceTemplate();
        ws.setDefaultUri(wsUrl);
//        ws.setMarshaller(marshaller);
//        ws.setUnmarshaller(unmarshaller);
        return ws;
    }

}
