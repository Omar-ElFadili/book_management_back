package com.react_formation.react_formation.mappers;

import com.react_formation.react_formation.DTO.requestsDTO.UserRequestDTO;
import com.react_formation.react_formation.DTO.responseDTO.UserResponseDTO;
import com.react_formation.react_formation.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO userRequestDTO);

    UserResponseDTO toDto(User user);


}
