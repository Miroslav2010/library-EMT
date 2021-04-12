package mk.ukim.finki.emt.biblioteka.web;

import mk.ukim.finki.emt.biblioteka.models.Book;
import mk.ukim.finki.emt.biblioteka.models.dto.BookDto;
import mk.ukim.finki.emt.biblioteka.models.enumeration.Category;
import mk.ukim.finki.emt.biblioteka.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/","/books"})
    public List<Book> getAll(){
        return this.bookService.listAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return this.bookService.findById(id).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/books/add")
    public ResponseEntity<Book> addNewBook(@RequestBody BookDto bookDto){
        return this.bookService.addNewBook(bookDto).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/books/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.editBook(id, bookDto).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/books/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/books/markTaken/{id}")
    public ResponseEntity markTaken(@PathVariable Long id){
        boolean tmp = this.bookService.markAsTaken(id);
        if(tmp){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        List<Category> list = new ArrayList<>();
        for (Category c: Category.values()) {
            list.add(c);
        }
        return list;
    }
}
