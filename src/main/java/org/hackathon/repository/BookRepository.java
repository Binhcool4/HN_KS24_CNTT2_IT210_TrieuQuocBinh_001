package org.hackathon.repository;

import org.hackathon.model.dto.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    boolean addEmployee(Book employee);
    boolean deleteBook(Long id);
    List<Book> findByName(String empName);


}
