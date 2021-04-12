package mk.ukim.finki.emt.biblioteka.service;

import mk.ukim.finki.emt.biblioteka.models.Author;
import mk.ukim.finki.emt.biblioteka.models.Country;
import mk.ukim.finki.emt.biblioteka.models.dto.AuthorDto;
import mk.ukim.finki.emt.biblioteka.models.dto.CountryDto;

import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(Long id);
    Optional<Country> addNewCountry(CountryDto countryDto);
    void deleteById(Long id);
}
