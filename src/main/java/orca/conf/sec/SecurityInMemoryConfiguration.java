package orca.conf.sec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//@Configuration
//@EnableWebSecurity // (debug = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityInMemoryConfiguration 
//extends WebSecurityConfigurerAdapter 
{
    private static final Logger log = LoggerFactory.getLogger(SecurityInMemoryConfiguration.class);
    @Autowired
    RefererRedirectionAuthenticationSuccessHandler refererSuccessHandler;
    
    @Autowired
    RESTAuthenticationSuccessHandler restAuthenticationSuccessHandler;
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and()//
//        .withUser("admin")
//                .password("admin").roles("USER", "ADMIN","ACTUATOR");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.httpBasic().and().authorizeRequests().antMatchers("/", "/home").permitAll() // allow home.html
//                .antMatchers("/hello").hasRole("ADMIN")//
//                .antMatchers("/api/v1*").hasRole("ADMIN")//
//                .anyRequest().authenticated()//
//                .and().csrf().disable();
//
//        http.formLogin().loginPage("/login").permitAll()
//        //.successForwardUrl("/hello")
//        ;
//        
//        //http.formLogin().successHandler(refererSuccessHandler);
//         http.formLogin().successHandler(restAuthenticationSuccessHandler);
//        // http.formLogin().failureHandler(authenticationFailureHandler);
//        http.logout().permitAll();//.logoutSuccessUrl("/");
//        log.error("In here");
//    }

}