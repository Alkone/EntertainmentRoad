package code;

import code.domain.cinematable.entrity.Cinema;
import code.domain.filmstable.entity.Film;
import code.domain.filmstable.filmsrepository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner dem(FilmRepository filmRepository){
        return (args)->{

           Set<Cinema> cinemas = new HashSet<>();
           cinemas.addAll(Arrays.asList(new Cinema("Tower", "Kutuzovskaya"),
                                        new Cinema("Oko", "Barikadnaya"),
                                        new Cinema("Plaza", "Univer")));
           Film film = new Film("Avengers",250);
           film.addAllCinemas(cinemas);
           filmRepository.save(film);
           cinemas = new HashSet<>();
            cinemas.addAll(Arrays.asList(new Cinema("Tower", "Kutuzovskaya"),
                    new Cinema("Vision", "Stanislav"),
                    new Cinema("Plaza", "Univer")));
            film = new Film("Pirates",200);
            film.addAllCinemas(cinemas);
            filmRepository.save(film);
            cinemas = new HashSet<>();
            cinemas.addAll(Arrays.asList(new Cinema("Tower", "Kutuzovskaya"),
                    new Cinema("Zona", "Chinatown")));
            film = new Film("Gard",500);
            film.addAllCinemas(cinemas);
            filmRepository.save(film);
            cinemas = new HashSet<>();
            cinemas.addAll(Arrays.asList(new Cinema("Tower", "Kutuzovskaya"),
                    new Cinema("Oko", "Barikadnaya"),
                    new Cinema("Zona", "Chinatown"),
                    new Cinema("Vision", "Stanislav"),
                    new Cinema("Plaza", "Univer")));
            film = new Film("Monsters",200);
            film.addAllCinemas(cinemas);
            filmRepository.save(film);
        };
    }

}
