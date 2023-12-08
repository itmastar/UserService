package com.tdemo.user.mapper;

import com.tdemo.user.dto.UserDTO;
import com.tdemo.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    User userDTOtoUser(UserDTO user);
    UserDTO usertoUserDTO(User user);

}
