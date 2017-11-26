package failsafe.orca.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import failsafe.orca.EndpointTest;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = App.class)//,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InsuranceControllerTest extends EndpointTest {

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Test
    public void testDeployment() {
        testEndpoint("/api/v1/insuranceApplication/ON4548", "ON4548");
//        ResponseEntity<InsuranceApplication> responseEntity = restTemplate
//                .getForEntity("/api/v1/insuranceApplication/ON4548", InsuranceApplication.class);
//        InsuranceApplication client = responseEntity.getBody();
//        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
//        assertEquals("ON4548", client.getAppNumber());

    }
}
