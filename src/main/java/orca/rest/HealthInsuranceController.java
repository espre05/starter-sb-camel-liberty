package orca.rest;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import orca.domain.InsuranceApplication;
import orca.domain.PostalCode;
import orca.repo.PostalCodeRepository;

@RestController
@RequestMapping(value = "api/v1/", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class HealthInsuranceController {
    private static final Logger log = LoggerFactory.getLogger(HealthInsuranceController.class);

    @ApiOperation(value = "insuranceApplication", nickname = "insuranceApplication")
    @GetMapping(path = "/insuranceApplication/{appNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appNum", value = "Application Number", required = false, dataType = "string", paramType = "query", defaultValue = "ON4548") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = InsuranceApplication.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    public ResponseEntity<InsuranceApplication> getApp(@PathVariable String appNum) {
        InsuranceApplication app = new InsuranceApplication();
        app.setAppNumber(appNum);
        log.info("App num found " + appNum);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

    @Autowired
    PostalCodeRepository pcrepo;

    @GetMapping(path = "/postalcode/{postalCode}")
    public ResponseEntity<PostalCode> getPostalCode(@PathVariable String postalCode) {
        PostalCode pc1 = pcrepo.findOne(postalCode);
        log.info("Pcode found " + pc1);
        return new ResponseEntity<>(pc1, HttpStatus.OK);
    }
}