package com.oders.processor.services;

import com.oders.processor.domains.User;
import com.oders.processor.domains.UserInformation;
import com.oders.processor.dto.InfoDetailsDto;
import com.oders.processor.dto.UserLoginDto;
import com.oders.processor.mappers.UserInfoMapper;
import com.oders.processor.mappers.UserMapper;
import com.oders.processor.repository.UserInfoRepository;
import com.oders.processor.repository.UserRepository;
import com.oders.processor.response.InfoResponse;
import com.oders.processor.serviceInf.AdditionalInfoInf;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class AdditionalInfoService implements AdditionalInfoInf {

    private final UserInfoRepository userInfoRepository;
    private final InfoResponse infoResponse;
    private final UserRepository userRepository;

    public Object addInfoDetails(InfoDetailsDto infoDetailsDto) {
        Optional<User> user = userRepository.findUserByEmail(infoDetailsDto.getEmail());


        if (user.isEmpty()) {

            return infoResponse.infoResponseData(
                    Date.from(Instant.now()),
                    400,
                    "Error happend"
            );

        }

        UserInformation userInformation = UserInfoMapper.INSTANCE.infoDtoToUserInformation(infoDetailsDto);

        userInformation.setUser(user.get());

        UserLoginDto userLoginDto = UserMapper.INSTANCE.userToUserLoginDto(user.get());


        log.info("Data {}", userInformation);

        return infoResponse.infoDetailsResponseData(
                Date.from(Instant.now()),
                200,
                "Added Details",
                userLoginDto
        );


    }
}
