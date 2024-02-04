package com.oders.processor.mappers;

import com.oders.processor.domains.User;
import com.oders.processor.domains.UserInformation;
import com.oders.processor.dto.InfoDetailsDto;
import com.oders.processor.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoMapper {

    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    @Mapping(source = "address", target = "address")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "zipCode", target = "zipCode")
    UserInformation infoDtoToUserInformation(InfoDetailsDto infoDetailsDto);
}
