package com.irfanstore.product.controller;

import com.irfanstore.product.dto.EnvDto;
import com.irfanstore.product.service.EnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EnvController {

    @Autowired
    private EnvService envService;

    @GetMapping(path="/api/env")
    public ResponseEntity<List<EnvDto>> getEnv() {

        return new ResponseEntity<List<EnvDto>>(envService.getEnvVariables(), HttpStatus.OK);
    }
}
