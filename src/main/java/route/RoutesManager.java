package route;

import code.domain.cinematable.entrity.Cinema;
import route.graph.Graph;
import route.graph.algorithms.Dijkstras;
import route.graph.algorithms.IRoutable;
import transport.Station;
import transport.Undeground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoutesManager {
    public Undeground undeground;

    public RoutesManager(){
        initTestData();
    }

    public RoutesManager(Undeground undeground){
        this.undeground = undeground;
    }

    public Station getOptimalStation(IRoutable algorithm, List<String> usersStationsList, List<Cinema> cinemasList){
        List<ArrayList<Integer>> timeList = new ArrayList<>();
        for(int i=0; i<cinemasList.size(); i++){
            ArrayList<Integer> tmpList = new ArrayList<>();
            for(int j=0; j<usersStationsList.size(); j++){
                System.out.println(usersStationsList.get(j)+" "+cinemasList.get(i).getCinemaAddress());
                tmpList.add(algorithm.getShortestPathTime(undeground.getStationId(usersStationsList.get(j)) , undeground.getStationId(cinemasList.get(i).getCinemaAddress())));
                System.out.print(tmpList.get(j)+" "); //debug
            }
            timeList.add(tmpList);
            System.out.println(); //debug
        }
        ArrayList<Integer> avrgTimeList = new ArrayList<>();
        for(int i=0; i<cinemasList.size(); i++){
            int avrgTime = 0;
            for(int j=0; j<usersStationsList.size(); j++){
                avrgTime += timeList.get(i).get(j);
            }
            avrgTime /= usersStationsList.size();
            avrgTimeList.add(avrgTime);
        }
        int indexOfBestChoise = 0;
        int minimalDelay = 1000;
        //int [][] timeArray = new int[usersStationsList.size()][cinemasList.size()];
        for(int i=0; i<cinemasList.size(); i++){
            int tmpDelay = 0;
            for(int j=0; j<usersStationsList.size(); j++){
                tmpDelay += Math.abs(timeList.get(i).get(j)-avrgTimeList.get(i));
            }
            if(tmpDelay < minimalDelay){
                minimalDelay = tmpDelay;
                indexOfBestChoise = i;
            }
        }
        System.out.println("Best Choisen index is "+indexOfBestChoise+" with minimal zaderzhka = "+minimalDelay);
        return undeground.getStationById(indexOfBestChoise);
    }

    //
    public Station getOptimalStation(List<String> usersStationsList, List<Cinema> cinemasList){
        Graph g = new Graph(undeground);
        Dijkstras dijkstras = new Dijkstras(g);
        return getOptimalStation(dijkstras, usersStationsList, cinemasList);
    }

    private void initTestData(){
        undeground = new Undeground();
        HashMap<Integer,Integer> tempHM = new HashMap<>();

        //1 station
        tempHM.clear();
        tempHM.put(2,4);
        tempHM.put(6,3);
        undeground.addStation(new Station("Станция 1", new HashMap<>(tempHM)));

        //2 station
        tempHM.clear();
        tempHM.put(1,4);
        tempHM.put(3,5);
        undeground.addStation(new Station("Станция 2", new HashMap<>(tempHM)));

        //3 station
        tempHM.clear();
        tempHM.put(2,5);
        tempHM.put(8,3);
        tempHM.put(4,4);
        undeground.addStation(new Station("Станция 3", new HashMap<>(tempHM)));

        //4 station
        tempHM.clear();;
        tempHM.put(3,4);
        tempHM.put(5,3);
        undeground.addStation(new Station("Станция 4", new HashMap<>(tempHM)));

        //5 station
        tempHM.clear();
        tempHM.put(4,3);
        tempHM.put(6,2);
        undeground.addStation(new Station("Станция 5", new HashMap<>(tempHM)));

        //6 station
        tempHM.clear();
        tempHM.put(1,3);
        tempHM.put(5,2);
        tempHM.put(7,8);
        undeground.addStation(new Station("Станция 6", new HashMap<>(tempHM)));

        tempHM.clear();
        tempHM.put(6,8);
        tempHM.put(8,6);
        undeground.addStation(new Station("Станция 7", new HashMap<>(tempHM)));

        tempHM.clear();
        tempHM.put(7,6);
        tempHM.put(3,3);
        undeground.addStation(new Station("Станция 8", new HashMap<>(tempHM)));

    }
}