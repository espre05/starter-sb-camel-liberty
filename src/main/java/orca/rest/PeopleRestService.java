package orca.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import orca.domain.Person;

@Path("people")
@Component
public class PeopleRestService {
    @GET
    @Produces({MediaType.APPLICATION_JSON
        //,MediaType.APPLICATION_XML 
        })
    //@Path("people")
    public Person getPeople() {
        return (new Person("a@b.com", "John", "Smith"));
    }
}