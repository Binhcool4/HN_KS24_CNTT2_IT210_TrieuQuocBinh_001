package org.hackathon.service;

import org.hackathon.model.Book;
import org.hackathon.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookService {
    private final BookRepository repo;

        public BookService(BookRepository repo) {
            this.repo = repo;
        }

        public List<Book> findAll() {
            return repo.findAll();
        }

        public void save(Book b) {
            repo.save(b);
        }

        public Book findById(Long id) {
            return repo.findById(id);
        }

        public void delete(Long id) {
            repo.delete(id);
        }

        public List<Book> search(String keyword) {
            return repo.findAll().stream()
                    .filter(b ->
                            (keyword == null || b.getTitle().toLowerCase().contains(keyword.toLowerCase())
                                    || b.getAuthor().toLowerCase().contains(keyword.toLowerCase()))).collect(Collectors.toList());
        }
}
