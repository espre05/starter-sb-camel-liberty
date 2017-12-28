package orca.conf;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import orca.rest.PersonsRestService;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = PersonsRestService.class)
public class CxfConfig {
    @Autowired private PersonsRestService personsRestService;
 
    @Bean(name=Bus.DEFAULT_BUS_ID,destroyMethod = "shutdown")
    public SpringBus springBus() {      
        return new SpringBus();
    }
    final String cxfUrlPrefix = "/apicxf/*";
    @Bean(destroyMethod = "destroy") 
    @DependsOn("cxf")
    public Server jaxRsServer() {
        
        
        final JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
            
        factory.setServiceBean(personsRestService);
        factory.setProvider(new JacksonJsonProvider());
        factory.setBus(springBus());
        factory.setAddress("/rest"); //http://localhost:9080/prem-orca/api/cxf/rest/persons
        return factory.create();
    }

    @Bean
    public ServletRegistrationBean cxfServlet() {
        final ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(),cxfUrlPrefix);
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }
}