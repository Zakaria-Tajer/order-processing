package com.oders.processor.controller;


import com.oders.processor.dto.InfoDetailsDto;
import com.oders.processor.services.AdditionalInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/additional-info")
@Slf4j
@RequiredArgsConstructor
public class UserInfoController {


    private final AdditionalInfoService additionalInfoService;


    @PostMapping("/addinfo")
    public ResponseEntity<Object> addingInfoData(@RequestBody InfoDetailsDto infoDetailsDto) {
        return ResponseEntity.ok().body(additionalInfoService.addInfoDetails(infoDetailsDto));
    }
}
