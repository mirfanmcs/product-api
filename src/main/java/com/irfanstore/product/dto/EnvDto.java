package com.irfanstore.product.dto;

import lombok.Data;

@Data
public class EnvDto {
    private String variableName;
    private String variableValue;

    public EnvDto(String vName, String vValue)  {
        variableName = vName;
        variableValue = vValue;
    }
}
