package com.oders.processor.services;


import com.oders.processor.domains.User;
import com.oders.processor.dto.UserDto;
import com.oders.processor.dto.UserLoginDto;
import com.oders.processor.mappers.UserMapper;
import com.oders.processor.repository.UserRepository;
import com.oders.processor.response.AuthResponse;
import com.oders.processor.security.ApplicationConfig;
import com.oders.processor.serviceInf.UserServiceInf;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserServiceInf {


    private final UserRepository userRespository;
    private final ApplicationConfig applicationConfig;
    private final JwtService jwtService;
    private final AuthResponse authResponse;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Override
    public Object registerUser(UserDto userDto) {

        Optional<User> userExist = userRespository.findUserByEmail(userDto.getEmail());

        userExist.ifPresent(user -> authResponse.authResponseError(
                user.getEmail(),
                Date.from(Instant.now()),
                400,
                "This email is already used"
        ));

        userDto.setPassword(applicationConfig.passwordEncoder().encode(userDto.getPassword()));


        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        userRespository.save(user);

        log.info("New User Saved");

//        ! should add a checker if the mapping has data


        return authResponse.registerResponse(
                Date.from(Instant.now()),
                200,
                "success",
                UserMapper.INSTANCE.userToUserDto(user)
        );
    }

    @Override
    public Object loginUser(UserDto loginDto) {
        if (loginDto.getEmail() == null) {

            log.info("This email is already used");
            return authResponse.authResponseDefaultError(

                    Date.from(Instant.now()),
                    400,
                    "This email is already used"

            );
        }


        Optional<User> user = userRespository.findUserByEmail(loginDto.getEmail());


        if (user.isEmpty()) {
            log.info("No user with this email");

            authResponse.authResponseDefaultError(
                    Date.from(Instant.now()),
                    400,
                    "No user with this email"
            );
        }

        if (user.isPresent() && !applicationConfig.passwordEncoder().matches(loginDto.getPassword(), user.get().getPassword())) {
            log.info("Passwords do not match");

            authResponse.authResponseDefaultError(
                    Date.from(Instant.now()),
                    400,
                    "Passwords do not match"
            );

        }

        try {
            // Try to authenticate the user using the provided email and password
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getEmail(),
                            loginDto.getPassword()
                    )
            );

            User authenticatedUser = (User) authentication.getPrincipal();

            // Generate the JWT token and return it, or handle the successful login as needed.
            String jwtToken = jwtService.generateToken(authenticatedUser);
            UserLoginDto userLoginDto = UserMapper.INSTANCE.userToUserLoginDto(authenticatedUser);

            log.info("user {} logged", authenticatedUser.getEmail());

            return authResponse.authResponseLoginData(
                    Date.from(Instant.now()),
                    200,
                    "Logged",
                    jwtToken,
                    userLoginDto
            );


        } catch (AuthenticationException ex) {

            return authResponse.authResponseDefaultError(
                    Date.from(Instant.now()),
                    401,
                    String.format("Invalid credentials {}", ex.getMessage())
            );
        }


    }


}