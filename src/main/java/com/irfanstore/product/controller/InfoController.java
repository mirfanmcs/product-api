package com.irfanstore.product.controller;

import com.irfanstore.product.dto.InfoDto;
import com.irfanstore.product.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/api/info")
    public ResponseEntity<List<InfoDto>> getInfo(@RequestHeader Map<String, String> headers) {

        return new ResponseEntity<List<InfoDto>>(infoService.getInfo(headers), HttpStatus.OK);
    }

    @GetMapping("/api/username")
    public ResponseEntity<String> username(@RequestHeader("x-ms-client-principal-name") String username) {
        return new ResponseEntity<String>(username, HttpStatus.OK);
    }

    @GetMapping("/api/username2")
    public ResponseEntity<String> username2(@RequestHeader("X-MS-CLIENT-PRINCIPAL-NAME") String username) {
        return new ResponseEntity<String>(username, HttpStatus.OK);
    }

    @GetMapping("/api/greeting")
    public ResponseEntity<String> greeting() {

        return new ResponseEntity<String>("Hello world2", HttpStatus.OK);
    }

}
