package com.react_formation.react_formation.repositories;

import com.react_formation.react_formation.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
