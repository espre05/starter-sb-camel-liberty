package orca.conf;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value= "file:/var/tmp/${spring.application.name}/conf/override.properties", ignoreResourceNotFound = true)
@PropertySource(value= "classpath:application.properties", ignoreResourceNotFound = true)
//@ImportResource("classpath:property-config.xml")
//@PropertiesValueSource({"classpath:com/acme/a.properties", "file:/opt/acme/b.properties"})
public class AppConfig {
    @Bean
    public PropertyPlaceholderConfigurer placeholderConfigurer(){
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setIgnoreUnresolvablePlaceholders(true);
        configurer.setIgnoreResourceNotFound(true);
        return configurer;
    }
}
