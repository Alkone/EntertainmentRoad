package code.route.graph;

import code.transport.ITransport;
import code.transport.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    // Map FromVertexId -> ToVertex
    private final Map<Integer, List<Vertex>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public Graph(ITransport transport) {
        this();
        List<Station> stations = transport.getStations();
        for (Station station: stations) {
            addVertex(station.getId(), station.getNearStations());
        }
    }

    public void addVertex(Integer vertexId, List<Vertex> vertex) {
        this.vertices.put(vertexId, vertex);
    }

    public void addVertex(Integer vertexId, HashMap<Integer,Integer> nearStations) {
        List<Vertex> vertexs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : nearStations.entrySet()) {
        vertexs.add(new Vertex(entry.getKey(), entry.getValue()));
        }
        this.vertices.put(vertexId, vertexs);
    }

    public Map<Integer, List<Vertex>> getVertices() {
        return vertices;
    }
}
