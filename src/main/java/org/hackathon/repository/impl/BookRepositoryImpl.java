package org.hackathon.repository.impl;

import org.springframework.stereotype.Repository;
import org.hackathon.model.dto.Book;
import org.hackathon.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> books;

    public BookRepositoryImpl(){
        books = new ArrayList<>();
        books.add(new Book(1L,"Đắc Nhân Tâm","Dũng",10,"duc.jpg"));
        books.add(new Book(2L,"Truyện Kiều","Du",9,"lan.jpg"));
        books.add(new Book(3L,"Liêu Trai Tri Dị","Dung",8,"quan.jpg"));
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public boolean addEmployee(Book employee) {
        return books.add(employee);
    }

    @Override
    public boolean deleteBook(Long id) {
        Book employee = books.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if(employee!=null){
            return books.remove(employee);
        }
        return false;
    }

    @Override
    public List<Book> findByName(String title) {
        return books.stream().filter(e -> e.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
    }
}
