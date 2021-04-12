package mk.ukim.finki.emt.biblioteka.repository;

import mk.ukim.finki.emt.biblioteka.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
