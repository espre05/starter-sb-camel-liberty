package orca.app.rest;

import org.junit.Test;

import orca.app.EndpointTest;

public class HelloControllerTest extends EndpointTest {


    //@Test
    public void testDeployment() {
        testEndpoint("/api/v1/insuranceApplication/ON4548", "<appNumber>ON4548</appNumber>");
    }
}
