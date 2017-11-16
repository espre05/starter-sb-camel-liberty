package sb.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HelloController {
    @ApiOperation(value = "hello", nickname = "hello")
//    @ApiResponses(value = { 
//            @ApiResponse(code = 200, message = "Success", response = Greeting.class),
//            @ApiResponse(code = 401, message = "Unauthorized"),
//            @ApiResponse(code = 403, message = "Forbidden"),
//            @ApiResponse(code = 404, message = "Not Found"),
//            @ApiResponse(code = 500, message = "Failure")}) 
    @RequestMapping("/helloweb")
    public String hello() {
        return "Hello from Spring Boot MVC running on Liberty!";
    }

}
