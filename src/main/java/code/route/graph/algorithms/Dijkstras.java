package code.route.graph.algorithms;

import code.route.graph.Graph;
import code.route.graph.Vertex;

import java.util.*;

public class Dijkstras implements IRoutable {

    private Graph graph;
    private boolean fastestTimeSet;
    private int fastestTime;


    public Dijkstras(Graph graph){
        this.graph = graph;
    }

    @Override
    public int getShortestPathTime(int startStationId, int targetStationId) {
        findShortestPath(graph, startStationId, targetStationId);
        return fastestTime;
    }

    //Find shortest path by Dijkstras algorithm
    private List<Integer> findShortestPath(Graph graph, Integer startId, Integer finish) {
        final Map<Integer, Integer> distances = new HashMap<>();
        final Map<Integer, Vertex> previous = new HashMap<>();
        Map<Integer, List<Vertex>> vertices = graph.getVertices();
        PriorityQueue<Vertex> nodes = new PriorityQueue<>();
        fastestTime = 0;
        fastestTimeSet = false;

        //Задаются стартовые веса
        for (Integer vertexId : vertices.keySet()) {
            if (vertexId == startId) {
                distances.put(vertexId, 0);
                nodes.add(new Vertex(vertexId, 0));
            } else {
                distances.put(vertexId, Integer.MAX_VALUE);
                nodes.add(new Vertex(vertexId, Integer.MAX_VALUE));
            }
            previous.put(vertexId, null);
        }


        while (!nodes.isEmpty()) {
            Vertex smallest = nodes.poll();

            //Если путь с минимальной стоимостью равен искомой вершине
            if (smallest.getId() == finish) {
                final List<Integer> path = new ArrayList<>();
                while (previous.get(smallest.getId()) != null) {
                    if (!fastestTimeSet) {
                        fastestTime = smallest.getDistance();
                        fastestTimeSet = true;
                    }
                    path.add(smallest.getId());
                    smallest = previous.get(smallest.getId());
                }
                return path;
            }

            if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {
                break;
            }

            //смотрим все вершины
            for (Vertex neighbor : vertices.get(smallest.getId())) {
                Integer alt = distances.get(smallest.getId()) + neighbor.getDistance();
                if (alt < distances.get(neighbor.getId())) {
                    distances.put(neighbor.getId(), alt);
                    previous.put(neighbor.getId(), smallest);

                    forloop:
                    for (Vertex n : nodes) {
                        if (n.getId() == neighbor.getId()) {
                            nodes.remove(n);
                            n.setDistance(alt);
                            nodes.add(n);
                            break forloop;
                        }
                    }
                }
            }
        }
        return new ArrayList<>(distances.keySet());
    }
}


