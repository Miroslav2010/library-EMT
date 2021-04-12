package mk.ukim.finki.emt.biblioteka.repository;

import mk.ukim.finki.emt.biblioteka.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
