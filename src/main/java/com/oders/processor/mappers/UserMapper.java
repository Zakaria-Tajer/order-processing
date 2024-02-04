package com.oders.processor.mappers;


import com.oders.processor.domains.User;
import com.oders.processor.dto.UserDto;
import com.oders.processor.dto.UserLoginDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    @Mapping(target = "role", source = "role")
    UserDto userToUserDto(User user);

    @InheritInverseConfiguration
    UserLoginDto userToUserLoginDto(User user);

    @InheritInverseConfiguration
    User userDtoToUser(UserDto userDto);


}