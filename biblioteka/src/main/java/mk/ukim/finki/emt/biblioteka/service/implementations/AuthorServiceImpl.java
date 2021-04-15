package mk.ukim.finki.emt.biblioteka.service.implementations;

import mk.ukim.finki.emt.biblioteka.models.Author;
import mk.ukim.finki.emt.biblioteka.models.dto.AuthorDto;
import mk.ukim.finki.emt.biblioteka.models.exception.InvalidCountryIdException;
import mk.ukim.finki.emt.biblioteka.repository.AuthorRepostitory;
import mk.ukim.finki.emt.biblioteka.repository.CountryRepository;
import mk.ukim.finki.emt.biblioteka.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepostitory authorRepostitory;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepostitory authorRepostitory, CountryRepository countryRepository) {
        this.authorRepostitory = authorRepostitory;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepostitory.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepostitory.findById(id);
    }

    @Override
    public Optional<Author> addNewAuthor(AuthorDto authorDto) {
        Author author = new Author(authorDto.name,authorDto.surname,
                this.countryRepository.findById(authorDto.country).orElseThrow(InvalidCountryIdException::new));
        return Optional.of(this.authorRepostitory.save(author));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepostitory.deleteById(id);
    }
}
