package com.oders.processor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoDetailsData {


    private Date timestamp;
    private int statusCode;
    private String message;
}
