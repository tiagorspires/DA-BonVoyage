package GraphManager;

import java.util.LinkedList;

/*
*  Directed and Weighted Graph
*   Each node is numbered from 1 to N (number of nodes)
*   public int NumVertices - the number of vertices on the graph
*   Vertex[] graph - it stores an array of vertices, each one of the vertices store the corresponding node number and a List of Edges it has,
*   therefore it indirectly corresponds to all vertices witch has a connection with it
*
* */


public class Graph {
    public int NumVertices;
    Vertex[] graph;

    public Graph(int NumVertices) {
        this.NumVertices = NumVertices;
        graph = new Vertex[NumVertices];
        for (int i = 0; i < NumVertices; i++) { // for each node there is on the graph, create a new LinkedList for each one of it's connection
            graph[i] = new Vertex(i);
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(destination, weight);
        graph[source].addEdge(edge); //for directed graph
    }

    public void addEdge(int source, int destination, int weight, int duration) {
        Edge edge = new Edge(destination, weight, duration);
        graph[source].addEdge(edge); //for directed graph
    }

    public LinkedList<Edge> getEdgeList(int source){
        return graph[source].getAdjacentes();
    }

    public int getWeightOnEdge(int source, int destination){
        LinkedList<Edge> edges = getEdgeList(source);
        for (Edge edge: edges) {
            if(destination == edge.destination)
                return edge.weight;
        }
        return 0;
    }

    public int getDurationOnEdge(int source, int destination){
        LinkedList<Edge> edges = getEdgeList(source);
        for (Edge edge: edges) {
            if(destination == edge.destination)
                return edge.duration;
        }
        return 0;
    }

    public void printGraph(){
        for (int source = 0; source < NumVertices; source++) {
            LinkedList<Edge> list = graph[source].adjacentes;
            for (Edge edge : list) {
                System.out.println(" " + source + " ---> " +
                        edge.destination + " (w,d) = (" + edge.weight + "," + edge.duration + ")");
            }
        }
    }
}
