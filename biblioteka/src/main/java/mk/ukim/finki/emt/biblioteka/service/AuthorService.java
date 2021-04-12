package mk.ukim.finki.emt.biblioteka.service;

import mk.ukim.finki.emt.biblioteka.models.Author;
import mk.ukim.finki.emt.biblioteka.models.dto.AuthorDto;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);
    Optional<Author> addNewAuthor(AuthorDto authorDto);
    void deleteById(Long id);
}
