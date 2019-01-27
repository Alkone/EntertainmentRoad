package code.transport;

import java.util.HashMap;



public class Station {
    private static int globalId = 0;
    private int id;
    private String name;
    private HashMap<Integer, Integer> nearStations; //Near id station and time on way.

    public Station(String name, HashMap<Integer, Integer> nearStations){
        id = ++globalId;
        this.name = name;
        this.nearStations = nearStations;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Integer> getNearStations() {
        return nearStations;
    }

    public void setNearStations(HashMap<Integer, Integer> nearStations) {
        this.nearStations = nearStations;
    }
}
