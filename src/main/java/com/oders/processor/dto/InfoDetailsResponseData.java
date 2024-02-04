package com.oders.processor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoDetailsResponseData {


    private Date timestamp;
    private int statusCode;
    private String message;

    private UserLoginDto userLoginDto;
}
