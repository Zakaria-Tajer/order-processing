package com.oders.processor.controller;


import com.oders.processor.dto.UserDto;
import com.oders.processor.services.UserServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
@RequiredArgsConstructor
public class UserController {


    private final UserServiceImp userServiceImp;


    @PostMapping("/register")
    public ResponseEntity<Object> adminRegistration(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(userServiceImp.registerUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginAdmin(@RequestBody UserDto loginDto) {
        return ResponseEntity.ok().body(userServiceImp.loginUser(loginDto));
    }

}