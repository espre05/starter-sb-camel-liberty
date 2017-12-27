package orca.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import orca.domain.Person;


@Path("persons")
@Component
public class PersonsRestService {
    @GET
    @Produces({MediaType.APPLICATION_JSON //,MediaType.APPLICATION_XML
        })
    public Person getPeople() {
        Person p = new Person();//new Person("a@b.com", "John", "Smith")
        p.setFirstName("Hello");
        p.setLastName("abc");
        return p;
    }
}