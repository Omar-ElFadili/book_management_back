package com.react_formation.react_formation.services;

import com.react_formation.react_formation.DTO.requestsDTO.BookRequestDTO;
import com.react_formation.react_formation.DTO.responseDTO.BookResponseDTO;
import com.react_formation.react_formation.DTO.responseDTO.UserResponseDTO;
import com.react_formation.react_formation.entities.Book;
import com.react_formation.react_formation.entities.User;
import com.react_formation.react_formation.mappers.BookMapper;
import com.react_formation.react_formation.repositories.BookRepository;
import com.react_formation.react_formation.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImp implements BookService{
    private  final BookRepository bookRepository;
    private  final UserRepository userRepository;
    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found with id: " + id));
        return BookMapper.INSTANCE.toDto(book);
    }

    @Override
    public void saveBook(BookRequestDTO bookRequestDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookRequestDTO);
        Optional<User> optionalUser = userRepository.findById(bookRequestDTO.getUserId());
        User user = optionalUser.get();
        book.setOwner(user);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Long id, BookRequestDTO bookRequestDTO) {
        Optional<Book> optionalUser = bookRepository.findById(id);
        if (optionalUser.isPresent()) {
            Book book = BookMapper.INSTANCE.toEntity(bookRequestDTO);
            book.setId(id);
            bookRepository.save(book);
        } else {
            throw new RuntimeException("book not found with id: " + id);
        }
    }
}
