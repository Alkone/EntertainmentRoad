package route.graph;

public class Vertex implements Comparable<route.graph.Vertex>{

    private Integer id;
    private Integer distance;

    public Vertex(Integer id, Integer distance) {
        super();
        this.id = id;
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(route.graph.Vertex o) {
        if (this.distance < o.distance)
            return -1;
        else if (this.distance > o.distance)
            return 1;
        else
            return this.getId().compareTo(o.getId());
    }
}