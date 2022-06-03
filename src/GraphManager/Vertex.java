package GraphManager;

import java.util.LinkedList;

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
}
