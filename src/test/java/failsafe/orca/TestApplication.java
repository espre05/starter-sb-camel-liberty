package failsafe.orca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
public class TestApplication extends EndpointTest {

    @Test
    public void testDeployment() {
        testEndpoint("/index.html", "<h1>Welcome to your Liberty Application</h1>");
    }

}
