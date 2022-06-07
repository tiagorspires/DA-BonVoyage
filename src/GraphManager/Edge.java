package GraphManager;

/*
*  Each edge stores a destination, allowing the connection between node 'a' and node 'b'
*   it also stores the weight and a duration of each edge
*
*   It has two constructors, one of them missing the duration parameter for when it is not needed
* */

public class Edge implements Comparable<Edge>{
    int destination;
    int weight;
    int duration;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
        this.duration = 0;
    }

    public Edge(int destination, int weight, int duration) {
        this.destination = destination;
        this.weight = weight;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "destination=" + destination +
                ", weight=" + weight +
                '}';
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.destination == o.destination && this.weight == o.weight)
            return 0;
        return -1;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDuration() {
        return duration;
    }

}
