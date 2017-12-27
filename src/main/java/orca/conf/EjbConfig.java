package orca.conf;

import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ejb.access.SimpleRemoteStatelessSessionProxyFactoryBean;

import orca.ejb.ToUpperCase;

//@Configuration
public class EjbConfig {

    @Bean
    public FactoryBean getLoginManagerFactory() {
        SimpleRemoteStatelessSessionProxyFactoryBean factory = new SimpleRemoteStatelessSessionProxyFactoryBean();
        String beanName = "jndi.ejb3.ToUpperCase";
        factory.setJndiName(beanName);
        factory.setBusinessInterface(ToUpperCase.class);
        Properties p = new Properties();
        p.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        p.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        p.setProperty("java.naming.provider.url", "jnp:localhost:1099");
        factory.setJndiEnvironment(p);
        return factory;
    }
}
