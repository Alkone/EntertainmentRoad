package code.domain.filmstable.filmsrepository;

import code.domain.cinematable.entrity.Cinema;
import code.domain.filmstable.entity.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by valer on 27.01.2019.
 */
public interface FilmRepository extends CrudRepository<Film, Long>{
    Film getFilmByName(String name);

}
