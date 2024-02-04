package com.oders.processor.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oders.processor.enums.Roles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {


    private String firstName;
    private String lastName;
    private String email;

    @JsonIgnore
    private String password;
    private String image;

    @Enumerated(EnumType.STRING)
    private Roles role;
}