package orca.ejb;

import javax.ejb.Stateless;

@Stateless
public class SampleStatelessBean {

    public String hello() {
        return "Hello EJB World.";
    }
    
    public String toUpper(String s) {
        String out = "Hello EJB World. upper=";
        if(null != s) out += s.toUpperCase();
        return out;
    }
}