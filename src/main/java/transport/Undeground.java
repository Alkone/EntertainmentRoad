package transport;

import java.util.ArrayList;
import java.util.List;

public class Undeground implements ITransport {

    private List<Station> stationList;

    public Undeground(){
        stationList = new ArrayList<>();
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }

    //Add station
    public void addStation(Station station){
        stationList.add(station);
    }

    //Remove station by id
    public void removeStation(int stationId){
        for (Station station: stationList) {
            if(station.getId() == stationId){
                stationList.remove(station);
                break;
            }
        }
    }

    //Remove station by id
    public Station getStationById(int stationId) {
        for (Station station : stationList) {
            if (station.getId() == stationId) {
                return station;
            }
        }
        return null;
    }

    //Возвращает id станции по имени
    public int getStationId(String name){
        for (Station station : stationList) {
            if(station.getName().equals(name)){
                return station.getId();
            }
        }
        return 0; //if station not found
    }

    //Возвращает id станции по имени
    public String getStationName(int id){
        for (Station station : stationList) {
            if(station.getId() == id){
                return station.getName();
            }
        }
        return "Station not found!"; //if station not found
    }

    @Override
    public List<Station> getStations() {
        return stationList;
    }
}
