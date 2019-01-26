package route.graph;

import route.graph.algorithms.Dijkstras;

import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex(1, Arrays.asList(new Vertex(2, 2), new Vertex(8, 4)));
        g.addVertex(2, Arrays.asList(new Vertex(1, 2), new Vertex(3, 5), new Vertex(9, 5)));
        g.addVertex(3, Arrays.asList(new Vertex(2, 5), new Vertex(4, 1)));
        g.addVertex(4, Arrays.asList(new Vertex(3, 1), new Vertex(5, 4)));
        g.addVertex(5, Arrays.asList(new Vertex(4, 4), new Vertex(6, 6), new Vertex(10, 2)));
        g.addVertex(6, Arrays.asList(new Vertex(5, 6), new Vertex(7, 7), new Vertex(11, 9)));
        g.addVertex(7, Arrays.asList(new Vertex(6, 7), new Vertex(8, 3)));
        g.addVertex(8, Arrays.asList(new Vertex(1, 4), new Vertex(7, 3), new Vertex(12, 6)));
        g.addVertex(9, Arrays.asList(new Vertex(2, 5), new Vertex(11, 3)));
        g.addVertex(10, Arrays.asList(new Vertex(5, 2), new Vertex(11, 3)));
        g.addVertex(11, Arrays.asList(new Vertex(10, 3), new Vertex(9, 3), new Vertex(12, 8), new Vertex(6, 9)));
        g.addVertex(12, Arrays.asList(new Vertex(11, 8), new Vertex(8, 6)));

        Dijkstras dijkstras = new Dijkstras(g);
        System.out.println(dijkstras.getShortestPathTime(1,5));
    }
}
