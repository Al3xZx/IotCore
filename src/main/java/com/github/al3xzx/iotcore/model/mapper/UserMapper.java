package com.github.al3xzx.iotcore.model.mapper;

import com.github.al3xzx.iotcore.model.dto.UserDTO;
import com.github.al3xzx.iotcore.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
