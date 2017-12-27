package orca.conf.sec;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*
//TODO: http://www.baeldung.com/spring-security-multiple-auth-providers - add tests
 * https://github.com/eugenp/tutorials/tree/master/spring-security-mvc-boot/src/main/java/org/baeldung/multipleentrypoints
 * 
 * TODO: http://www.baeldung.com/spring-security-multiple-entry-points
 * - Order(2)
 * - guest or user or admin - 
 * 
 * TODO: http://www.baeldung.com/spring-security-redirect-login
 * - redirect to prev page
*/
//@EnableWebSecurity
public class MultipleAuthProvidersSecurityConfig 
//extends WebSecurityConfigurerAdapter 
{

    @Autowired
    CustomAuthenticationProvider customAuthProvider;

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.authenticationProvider(customAuthProvider);
//
//        auth.inMemoryAuthentication()
//            .withUser("memuser")
//            .password("pass")
//            .roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()
//            .and()
//            .authorizeRequests()
//            .antMatchers("/api/**")
//            .authenticated();
//    }
}