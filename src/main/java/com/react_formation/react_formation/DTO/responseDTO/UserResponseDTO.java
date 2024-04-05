package com.react_formation.react_formation.DTO.responseDTO;

import com.react_formation.react_formation.entities.Book;
import lombok.Data;

import java.util.List;
@Data
public class UserResponseDTO {
    private Long id;

    private String name;
    private String email;

    private List<Book> ownedBooks;
}
