package com.irfanstore.product.service;

import org.springframework.beans.factory.annotation.Value;
import com.irfanstore.product.dto.EnvDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnvService {

    //Injecting Environment variables

    @Value("${APPLICATION_NAME:Not Set}")
    private String applicationName;

    @Value("${COMPANY_NAME:Not Set}")
    private String companyName;

    @Value("${COMPANY_ADDRESS:Not Set}")
    private String companyAddress;

    @Value("${APPLICATION_SECRET_1:Not Set}")
    private String applicationSecret1;

    @Value("${APPLICATION_SECRET_2:Not Set}")
    private String applicationSecret2;

    public List<EnvDto> getEnvVariables() {
        List<EnvDto> envDtos = new ArrayList<EnvDto>();

        envDtos.add(new EnvDto("APPLICATION_NAME",applicationName));
        envDtos.add(new EnvDto("COMPANY_NAME", companyName));
        envDtos.add(new EnvDto("COMPANY_ADDRESS", companyAddress ));
        envDtos.add(new EnvDto("APPLICATION_SECRET_1", applicationSecret1 ));
        envDtos.add(new EnvDto("APPLICATION_SECRET_2", applicationSecret2));

        return envDtos;
    }

}
