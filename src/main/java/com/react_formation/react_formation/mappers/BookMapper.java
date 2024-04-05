package com.react_formation.react_formation.mappers;

import com.react_formation.react_formation.DTO.requestsDTO.BookRequestDTO;
import com.react_formation.react_formation.DTO.requestsDTO.UserRequestDTO;
import com.react_formation.react_formation.DTO.responseDTO.BookResponseDTO;
import com.react_formation.react_formation.DTO.responseDTO.UserResponseDTO;
import com.react_formation.react_formation.entities.Book;
import com.react_formation.react_formation.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id", ignore = true)
    Book toEntity(BookRequestDTO bookRequestDTO);

    BookResponseDTO toDto(Book book);
}
