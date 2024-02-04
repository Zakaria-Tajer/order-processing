package com.oders.processor.response;


import com.oders.processor.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthResponse {


    public AuthResponseData registerResponse(Date timestamp, int statusCode, String message, UserDto userData) {
        return new AuthResponseData(
                timestamp,
                statusCode,
                message,
                userData
        );
    }

    public AuthResponseError authResponseError(String email, Date timestamp, int statusCode, String message) {
        return new AuthResponseError(
                email,
                timestamp,
                statusCode,
                message
        );
    }

    public AuthResponseDefaultError authResponseDefaultError(Date timestamp, int statusCode, String message) {
        return new AuthResponseDefaultError(
                timestamp,
                statusCode,
                message
        );
    }

    public AuthResponseLogin authResponseLoginData(Date timestamp, int statusCode, String message, String Token, UserLoginDto userLoginDto) {
        return new AuthResponseLogin(
                timestamp,
                statusCode,
                message,
                Token,
                userLoginDto
        );
    }

}
