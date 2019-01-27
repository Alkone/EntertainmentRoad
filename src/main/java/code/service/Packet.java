package code.service;

/**
 * Created by valer on 27.01.2019.
 */
public class Packet {
    private String cinemaname;
    private String price;

    public Packet(String cinemaname, double price) {
        this.cinemaname = cinemaname;
        this.price = String.valueOf(price);
    }

    public String getCinemaname() {
        return cinemaname;
    }

    public void setCinemaname(String cinemaname) {
        this.cinemaname = cinemaname;
    }

    public double getPrice() {
        return Double.parseDouble(price);
    }

    public void setPrice(double price) {
        this.price = String.valueOf(price);
    }
}
