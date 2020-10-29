package com.example.sbawebapp.repository;

import com.example.sbawebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
