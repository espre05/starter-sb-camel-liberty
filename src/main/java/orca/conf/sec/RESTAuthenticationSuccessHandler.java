package orca.conf.sec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

//@Component
public class RESTAuthenticationSuccessHandler 
//extends SavedRequestAwareAuthenticationSuccessHandler 
{
//    private static final Logger log = LoggerFactory.getLogger(RESTAuthenticationSuccessHandler.class);
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//	                                    Authentication authentication) throws IOException, ServletException {
//	    setUseReferer(true);
//	    log.error("In here");
//	    
        //String ctoken = (String) request.getSession().getAttribute(WebConstants.CSRF_TOKEN);
        //DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST_KEY");
//	    DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest)
//	            new HttpSessionRequestCache().getRequest(request, response);
//	    SavedRequest savedRequest =
//	            (SavedRequest)request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
//        if( savedRequest != null 
//                //&& ctoken != null 
//                ) {
//            String requestUrl = savedRequest.getRedirectUrl();
//            log.error("\n\tIn here requestUrl="+requestUrl);
//            String requestUrl = defaultSavedRequest.getRequestURL() + "?" + defaultSavedRequest.getQueryString();
//            //requestUrl = UrlTool.addParamToURL(requestUrl, WebConstants.CSRF_TOKEN, ctoken, true);
//            getRedirectStrategy().sendRedirect(request, response, requestUrl);
//        } else {
//            super.onAuthenticationSuccess(request, response, authentication);
//        }
//    }

}