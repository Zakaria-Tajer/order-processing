package com.oders.processor.response;


import com.oders.processor.dto.InfoDetailsData;
import com.oders.processor.dto.InfoDetailsResponseData;
import com.oders.processor.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class InfoResponse {

    public InfoDetailsData infoResponseData(Date timestamp, int statusCode, String message) {
        return new InfoDetailsData(
                timestamp,
                statusCode,
                message
        );
    }

    public InfoDetailsResponseData infoDetailsResponseData(Date timestamp, int statusCode, String message, UserLoginDto userLoginDto) {
        return new InfoDetailsResponseData(
                timestamp,
                statusCode,
                message,
                userLoginDto
        );
    }


}
