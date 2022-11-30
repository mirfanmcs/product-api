package com.irfanstore.product.dto;

import lombok.Data;

@Data
public class InfoDto {
    private String variableName;
    private String variableValue;

    public InfoDto(String vName, String vValue)  {
        variableName = vName;
        variableValue = vValue;
    }
}
