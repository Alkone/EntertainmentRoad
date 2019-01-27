package route;

import route.graph.Graph;
import route.graph.algorithms.Dijkstras;
import transport.Station;
import transport.Undeground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
        Undeground undeground = new Undeground();
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


        Graph g = new Graph(undeground);
//        g.addVertex(1, Arrays.asList(new Vertex(2, 2), new Vertex(8, 4)));
//        g.addVertex(2, Arrays.asList(new Vertex(1, 2), new Vertex(3, 5), new Vertex(9, 5)));
//        g.addVertex(3, Arrays.asList(new Vertex(2, 5), new Vertex(4, 1)));
//        g.addVertex(4, Arrays.asList(new Vertex(3, 1), new Vertex(5, 4)));
//        g.addVertex(5, Arrays.asList(new Vertex(4, 4), new Vertex(6, 6), new Vertex(10, 2)));
//        g.addVertex(6, Arrays.asList(new Vertex(5, 6), new Vertex(7, 7), new Vertex(11, 9)));
//        g.addVertex(7, Arrays.asList(new Vertex(6, 7), new Vertex(8, 3)));
//        g.addVertex(8, Arrays.asList(new Vertex(1, 4), new Vertex(7, 3), new Vertex(12, 6)));
//        g.addVertex(9, Arrays.asList(new Vertex(2, 5), new Vertex(11, 3)));
//        g.addVertex(10, Arrays.asList(new Vertex(5, 2), new Vertex(11, 3)));
//        g.addVertex(11, Arrays.asList(new Vertex(10, 3), new Vertex(9, 3), new Vertex(12, 8), new Vertex(6, 9)));
//        g.addVertex(12, Arrays.asList(new Vertex(11, 8), new Vertex(8, 6)));

        Dijkstras dijkstras = new Dijkstras(g);
        System.out.println(dijkstras.getShortestPathTime(1,8));
    }
}
