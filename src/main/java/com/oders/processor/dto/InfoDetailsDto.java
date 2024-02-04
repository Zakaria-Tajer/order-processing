package com.oders.processor.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoDetailsDto {


    private String email;
    private String address;
    private String phoneNumber;
    private String zipCode;


}
