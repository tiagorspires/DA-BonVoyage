package GraphManager;

import java.util.LinkedList;

/*
*  Main component of a graph, it stores an integer with its tag and a List of Edges it has
* */

public class Vertex {
    int node;
    LinkedList<Edge> adjacentes;

    public Vertex(int node) {
        this.node = node;
        this.adjacentes = new LinkedList<>();
    }

    public void addEdge(Edge novo){
        adjacentes.add(novo);
    }

    public LinkedList<Edge> getAdjacentes() {
        return adjacentes;
    }
}
