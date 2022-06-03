package GraphManager;

public class Edge implements Comparable<Edge>{
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge o) {
        if(this.destination == o.destination && this.weight == o.weight)
            return 0;
        return -1;
    }
}
