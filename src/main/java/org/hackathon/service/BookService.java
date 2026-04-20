package org.hackathon.service;

import org.springframework.web.multipart.MultipartFile;
import org.hackathon.model.dto.Book;

import java.util.List;

public interface BookService {
    List<Book> getBook();
    boolean insertEmployee(Book employee);
    boolean deleteBook(Long id);
    List<Book> searchByTitle(String title);
    String uploadToLocal(MultipartFile file);
}
