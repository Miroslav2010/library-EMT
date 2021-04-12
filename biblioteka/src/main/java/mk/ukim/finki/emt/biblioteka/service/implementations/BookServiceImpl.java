package mk.ukim.finki.emt.biblioteka.service.implementations;

import mk.ukim.finki.emt.biblioteka.models.Book;
import mk.ukim.finki.emt.biblioteka.models.dto.BookDto;
import mk.ukim.finki.emt.biblioteka.models.enumeration.Category;
import mk.ukim.finki.emt.biblioteka.models.exception.InvalidAuthorIdException;
import mk.ukim.finki.emt.biblioteka.models.exception.InvalidBookIdException;
import mk.ukim.finki.emt.biblioteka.repository.AuthorRepostitory;
import mk.ukim.finki.emt.biblioteka.repository.BookRepository;
import mk.ukim.finki.emt.biblioteka.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepostitory authorRepostitory;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepostitory authorRepostitory) {
        this.bookRepository = bookRepository;
        this.authorRepostitory = authorRepostitory;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id){
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> addNewBook(BookDto bookDto) {
        Book book = new Book(bookDto.name,Category.valueOf(bookDto.category),
                this.authorRepostitory.findById(bookDto.author).orElseThrow(InvalidAuthorIdException::new),
                bookDto.availableCopies);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> editBook(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        book.setName(bookDto.name);
        book.setAuthor(this.authorRepostitory.findById(bookDto.author).orElseThrow(InvalidAuthorIdException::new));
        book.setCategory(Category.valueOf(bookDto.category));
        book.setAvailableCopies(bookDto.availableCopies);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public boolean markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        if(book.getAvailableCopies() == 0){
            return false;
        }
        book.setAvailableCopies(book.getAvailableCopies()-1);
        this.bookRepository.save(book);
        return true;
    }
}
