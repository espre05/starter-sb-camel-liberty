package failsafe.orca.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import failsafe.orca.EndpointTest;
import orca.App;
import orca.domain.InsurApplication;
import orca.domain.MunicipalCode;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrcaControllerTest extends EndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getApp() {
        ResponseEntity<InsurApplication> responseEntity = restTemplate
                .getForEntity("/api/v1/insuranceApplication/RA0001", InsurApplication.class);
        InsurApplication app = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        //assertEquals("ON4548", app.getAppNumber());
    }

    @Test
    public void getPostCode() {
        ResponseEntity<MunicipalCode> responseEntity = restTemplate.getForEntity("/api/v1/postalcode/A1AA1A",
                MunicipalCode.class);
        MunicipalCode pcode = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        //assertEquals(123, pcode.getMunicipalityCode());
    }
}
