package orca.rest;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
import orca.domain.Note;
import orca.domain.PostalCode;
import orca.repo.InsurApplicationRepository;
import orca.repo.NoteRepository;
import orca.repo.PostalCodeRepository;

@RestController
@RequestMapping(value = "api/v1/", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Path("api/v1/")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
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

    @Autowired
    PostalCodeRepository pcrepo;

    @GetMapping(path = "/postalcode/{postalCode}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "postalCode", dataType = "string", paramType = "path", defaultValue = "A1AA1A") 
        })
    public ResponseEntity<PostalCode> getPostalCode(@PathVariable String postalCode) {
        PostalCode pc1 = pcrepo.findOne(postalCode);
        log.info("Pcode found " + pc1);
        return new ResponseEntity<>(pc1, HttpStatus.OK);
    }

    @Autowired
    NoteRepository noteRepo;

    @GetMapping(path = "/notes/{id}/{code}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", defaultValue = "1") 
        ,@ApiImplicitParam(name = "code", dataType = "string", paramType = "path", defaultValue = "E") 
        })
    public ResponseEntity<List<Note>> getNote(@PathVariable int id,@PathVariable Character code) {
        List<Note> note = noteRepo.findByIdAndCode(id, code);
        log.info("Note found " + note);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }
}