package mk.ukim.finki.emt.biblioteka.repository;

import mk.ukim.finki.emt.biblioteka.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepostitory extends JpaRepository<Author,Long> {
}
