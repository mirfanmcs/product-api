package com.irfanstore.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class HealthController {


    @GetMapping(path="/api/health")
    public ResponseEntity getProducts() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
