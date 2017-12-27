package orca.ejb;

import javax.ejb.Local;

@Local
public interface MyFacadeLocal {

    String myFacadeToUpper(String s);

}
