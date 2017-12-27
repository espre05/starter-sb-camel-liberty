package orca.conf.sec;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//@Controller
//@RequestMapping
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public ModelAndView projectBase() {
        return new ModelAndView("redirect:/home");
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, Model model) {
        String referrer = request.getHeader("Referer"); // Yes, with the legendary misspelling.
        request.getSession().setAttribute("url_prior_login", referrer);
        log.info("\nRefferer : " +referrer);
        log.info("\nparamMap : " + Arrays.toString(request.getParameterMap().entrySet().toArray()));
        log.info("\nparamMap : " + request.getRequestURI());
        log.error("In here");
        
        // some other stuff
        return "login";
    }
}