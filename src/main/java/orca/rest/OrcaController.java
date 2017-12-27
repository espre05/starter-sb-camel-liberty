package orca.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.camel.EndpointInject;
import org.apache.camel.FluentProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import orca.domain.InsurApplication;
import orca.domain.MunicipalCode;
import orca.domain.Notetext;
import orca.ejb.SampleStatelessBean;
import orca.repo.InsurApplicationRepository;
import orca.repo.MunicipalCodeRepository;
import orca.repo.NoteRepository;

@RestController
@RequestMapping(value = "api/v1/", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Path("api/v1/")
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
@Component
public class OrcaController {
    private static final Logger log = LoggerFactory.getLogger(OrcaController.class);

    @Autowired
    InsurApplicationRepository insurAppRepo;
    @ApiOperation(value = "insuranceApplication", nickname = "insuranceApplication")
    @GetMapping(path = "/insuranceApplication/{appNum}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appNum", value = "Application Number", required = false, dataType = "string", paramType = "path", defaultValue = "RA0001") 
            })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = InsurApplication.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    public ResponseEntity<InsurApplication> getApp(@PathVariable String appNum) {
        InsurApplication app = insurAppRepo.findOne(appNum);
               
        log.info("App num found " + appNum);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }
    
    @EndpointInject(uri = "direct:insuranceProcess")
    private FluentProducerTemplate producer;

    @GetMapping(path = "/postalcodecamel/{postalCode}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "postalCode", dataType = "string", paramType = "path", defaultValue = "K0A1A") 
        })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MunicipalCode.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    public ResponseEntity<MunicipalCode> getPostalCodeCamel(@PathVariable String postalCode) {
        MunicipalCode where = producer.withBody(postalCode).request(MunicipalCode.class); 
        log.info("\n Code from camel :" + where);
        return new ResponseEntity<>(where, HttpStatus.OK);
    }
    @Autowired
    MunicipalCodeRepository pcrepo;

    @GetMapping(path = "/postalcode/{postalCode}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "postalCode", dataType = "string", paramType = "path", defaultValue = "K0A1A") 
        })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MunicipalCode.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    public ResponseEntity<MunicipalCode> getPostalCode(@PathVariable String postalCode) {
        MunicipalCode where = pcrepo.findOne(postalCode);
        log.info("Pcode found " + where);
        return new ResponseEntity<>(where, HttpStatus.OK);
    }
    @Autowired
    NoteRepository noteRepo;

    @GetMapping(path = "/notes/{id}/{code}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", defaultValue = "1") 
        ,@ApiImplicitParam(name = "code", dataType = "string", paramType = "path", defaultValue = "E") 
        })
    public ResponseEntity<List<Notetext>> getNote(@PathVariable int id,@PathVariable Character code) {
        List<Notetext> note = noteRepo.findByIdAndCode1(id, code);
        log.info("Note found " + note);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }
    
//    @EJB
//    SampleStatelessBean statelessBean;
//    @GetMapping(path = "/hello/{message")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "message", dataType = "string", paramType = "path", defaultValue = "go upper") 
//        })
//    public ResponseEntity<String> getNote(@PathVariable String message) {
//        String out = statelessBean.toUpper(message);
//        log.info("Ejb invoked :" + out);
//        return new ResponseEntity<>(out, HttpStatus.OK);
//    }
   
}