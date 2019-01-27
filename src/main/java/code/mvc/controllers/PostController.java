package code.mvc.controllers;

import code.domain.cinematable.cinemasrepository.CinemaRepository;
import code.domain.cinematable.entrity.Cinema;
import code.domain.filmstable.entity.Film;
import code.domain.filmstable.filmsrepository.FilmRepository;
import code.domain.userstable.entity.User;
import code.domain.userstable.usersrepository.UsersRepository;
import code.service.Packet;
import code.service.StationParser;
import code.transport.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import code.route.RoutesManager;

import java.util.*;

@Controller
public class PostController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private RoutesManager manager;

    @PostMapping("/registration")
    public String addUser(User user){
        User dbUser = usersRepository.getUserByUsername(user.getUsername());
        if (dbUser != null){
            return "registration";
        }

        user.setBalance(5000);
        user.setEnabled(true);
        usersRepository.save(user);

        return "redirect:/main";
    }

    @PostMapping("add")
    public String add(@RequestParam String name, @RequestParam String station, Map<String, Object> model){
        if (name.isEmpty() || station.isEmpty()){
            return "main";
        }
        Film film = filmRepository.getFilmByName(name);
        Set<Cinema> cinemas = film.getCinemas();
        List<Cinema> list = new ArrayList<>();
        cinemas.forEach(cinema -> {
            list.add(cinema);
        });
        Station station1 = manager.getOptimalStation(StationParser.getStations(station),list);
        if (station1.getName().equals("Не найдено")){
            return "main";
        }
        Cinema cinema = cinemaRepository.getCinemaByCinemaAddress(station1.getName()).get(0);
        model.put("packet",new Packet(cinema.getCinemaName(),filmRepository.getFilmByName(name).getCost()));
        return "main";
    }
}
