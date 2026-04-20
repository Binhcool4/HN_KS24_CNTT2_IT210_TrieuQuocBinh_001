package org.hackathon.service.impl;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.hackathon.model.dto.Book;
import org.hackathon.repository.BookRepository;
import org.hackathon.service.BookService;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    private ServletContext servletContext;
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository, ServletContext servletContext){
        this.bookRepository = bookRepository;
        this.servletContext = servletContext;
    }

    @Override
    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    @Override
    public boolean insertEmployee(Book employee) {
        return bookRepository.addEmployee(employee);
    }

    @Override
    public boolean deleteBook(Long id) {
        return bookRepository.deleteBook(id);
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepository.findByName(title);
    }

    @Override
    public String uploadToLocal(MultipartFile file) {

        return "";
    }
}
