package code.domain.cinematable.cinemasrepository;

import code.domain.cinematable.entrity.Cinema;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CinemaRepository extends CrudRepository<Cinema, Long>{
    List<Cinema> getCinemaByCinemaAddress(String address);

}
