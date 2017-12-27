package orca.ejb;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Stateless
@Component
public class MyFacadeEJB implements MyFacadeLocal {

    // automatically injected with a matching Spring bean
    //@Autowired
    private ToUpperCase myUpper;

    // for business method, delegate to POJO service impl.
    @Override
    public String myFacadeToUpper(String s) {
        return myUpper.toUpperCase(s);
    }
}