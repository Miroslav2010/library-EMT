package mk.ukim.finki.emt.biblioteka.service;

import mk.ukim.finki.emt.biblioteka.models.Book;
import mk.ukim.finki.emt.biblioteka.models.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    Optional<Book> findById(Long id);
    Optional<Book> addNewBook(BookDto bookDto);
    Optional<Book> editBook(Long id, BookDto bookDto);
    void deleteById(Long id);
    boolean markAsTaken(Long id);
}
