package com.react_formation.react_formation.DTO.requestsDTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class BookRequestDTO {

    private String title;
    private String author;
    private String genre;
    private String summary;
    private Long userId;
}
