package com.irfanstore.product.service;
import com.irfanstore.product.dto.InfoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class InfoService {
    public List<InfoDto> getInfo(Map<String, String> headers) {
        List<InfoDto> infoDtos = new ArrayList<InfoDto>();

        headers.forEach((key, value) -> {
                   infoDtos.add(new InfoDto(key, value));
          });

       // getAuthenticationInfo();


        return infoDtos;


    }

    public /*List<InfoDto>*/ void getAuthenticationInfo() {

        //List<InfoDto> infoDtos = new ArrayList<InfoDto>();

        String uri = "/.auth/me";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);

        //return infoDtos;

    }

}
