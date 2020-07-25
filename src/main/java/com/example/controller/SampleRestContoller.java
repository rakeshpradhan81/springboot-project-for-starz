package com.example.controller;

import com.example.delegate.SampleRestDelegate;
import com.example.model.AppRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Api(tags = "Sample Rest Controller")
public class SampleRestContoller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SampleRestDelegate sampleRestDelegate;

    @GetMapping(
            value = "/data",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(
            value = "Description of Value"
    )
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful operation"),
        @ApiResponse(code = 404, message = " Error while servicing method")})
    public Double retrieveData(@RequestBody AppRequest input) {
        logger.info("Input Value received in Service is: {}", input.toString());

       return sampleRestDelegate.processRequest(input);



    }
}