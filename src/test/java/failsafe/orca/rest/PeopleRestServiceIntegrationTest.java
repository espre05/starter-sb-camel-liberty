package failsafe.orca.rest;
import static com.jayway.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class PeopleRestServiceIntegrationTest {
	@Value("${local.server.port}") private int port;
	
	@Before
	public void setUp() {
		RestAssured.port = port;
	}
	
	@Test
	public void testListOfPersonsIsBeingReturnedSuccessfuly() {
		given()
			.when() 
			.contentType(ContentType.JSON)
			.get("/apicxf/people")
			.then()
			.statusCode(200)
			.log()
			.ifValidationFails();
	}
}