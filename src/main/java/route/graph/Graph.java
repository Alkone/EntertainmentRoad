package route.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    // Map FromVertexId -> ToVertex
    private final Map<Integer, List<Vertex>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Integer vertexId, List<Vertex> vertex) {
        this.vertices.put(vertexId, vertex);
    }

    public Map<Integer, List<Vertex>> getVertices() {
        return vertices;
    }
}
