package orca.app.rest;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import orca.app.domain.InsuranceApplication;
 
@RestController
@RequestMapping(value="api/v1/", produces = {"application/json","application/xml"})
public class HealthInsuranceController {
 
 
    @ApiOperation(value = "insuranceApplication", nickname = "insuranceApplication")
    @GetMapping(path="/insuranceApplication/{appNum}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "appNum", value = "Application Number", required = false, dataType = "string", paramType = "query", defaultValue="ON4548")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = InsuranceApplication.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public ResponseEntity<InsuranceApplication> getApp(@PathVariable String appNum) {
        InsuranceApplication app =  new InsuranceApplication();
        app.setAppNumber(appNum);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }
}