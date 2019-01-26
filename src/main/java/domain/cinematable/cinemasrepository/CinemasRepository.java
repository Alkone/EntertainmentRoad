package domain.cinematable.cinemasrepository;

import domain.cinematable.Film;
import domain.cinematable.entrity.Cinema;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface CinemasRepository extends CrudRepository<Cinema, Long> {
    String getCinemasByFilmsName(Set<Film> films);
}
