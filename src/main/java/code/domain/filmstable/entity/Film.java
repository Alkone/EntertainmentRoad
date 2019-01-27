package code.domain.filmstable.entity;

import code.domain.cinematable.entrity.Cinema;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String name;
    private double cost;

    public Film() {
    }

    public Film(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public Film(String name, double cost, Set<Cinema> cinemas) {
        this.name = name;
        this.cost = cost;
        this.cinemas = cinemas;
    }

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Cinema> cinemas = new HashSet<>();

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void addCinema(Cinema cinema){
        cinemas.add(cinema);
    }

    public void addAllCinemas(Set<Cinema> cinemas){
        cinemas.forEach(cinema -> {
            this.cinemas.add(cinema);
        });
    }

    public Set<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Set<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

}
