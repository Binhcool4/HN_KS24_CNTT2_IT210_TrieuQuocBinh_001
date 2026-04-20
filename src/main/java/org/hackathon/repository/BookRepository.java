package org.hackathon.repository;

import org.hackathon.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class BookRepository {
    private final Map<Long, Book> db = new HashMap<>();
        private Long currentId = 1L;

        public List<Book> findAll() {
            return new ArrayList<>(db.values());
        }
        public void save(Book book) {
            if (book.getId() == null) {
                book.setId(currentId++);
            }
            db.put(book.getId(), book);
        }

        public Book findById(Long id) {
            return db.get(id);
        }

        public void delete(Long id) {
            db.remove(id);
        }
}
