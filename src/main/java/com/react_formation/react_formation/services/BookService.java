package com.react_formation.react_formation.services;

import com.react_formation.react_formation.DTO.requestsDTO.BookRequestDTO;
import com.react_formation.react_formation.DTO.responseDTO.BookResponseDTO;

import java.util.List;

public interface BookService {

    public List<BookResponseDTO> getAllBooks();
    public BookResponseDTO getBookById(Long id);

    public void saveBook(BookRequestDTO bookRequestDTO);

    public void deleteBook(Long id);

    public void updateBook(Long id, BookRequestDTO bookRequestDTO);
}
