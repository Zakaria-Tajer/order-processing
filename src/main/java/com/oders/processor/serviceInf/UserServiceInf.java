package com.oders.processor.serviceInf;

import com.oders.processor.dto.UserDto;

public interface UserServiceInf {

    Object registerUser(UserDto userDto);

    Object loginUser(UserDto loginDto);


}