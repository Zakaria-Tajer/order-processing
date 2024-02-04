package com.oders.processor.dto;


import com.oders.processor.enums.Roles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String image;

    @Enumerated(EnumType.STRING)
    private Roles role;


}