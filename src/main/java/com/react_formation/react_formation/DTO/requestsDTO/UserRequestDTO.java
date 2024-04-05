package com.react_formation.react_formation.DTO.requestsDTO;

import com.react_formation.react_formation.entities.Book;
import lombok.Data;

import java.util.List;
@Data
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
}
