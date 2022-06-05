package GraphManager;

import java.util.LinkedList;
import java.util.List;
/*
*  Directed and Weighted Graph
*   Each node is numbered from 1 to N (number of nodes)
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

    public List<Edge> getEdgeList(int source){
        return graph[source].getAdjacentes();
    }

    public int getWeightOnEdge(int source, int destination){
        for (Edge edge: graph[source].adjacentes) {
            if(destination == edge.destination)
                return edge.weight;
        }
        return 0;
    }


    public void printGraph(){
        for (int source = 0; source < NumVertices; source++) {
            LinkedList<Edge> list = graph[source].adjacentes;
            for (int j = 0; j <list.size() ; j++) {
                System.out.println(" " + source + " ---> " +
                        list.get(j).destination + " w(" + list.get(j).weight + ")");
            }
        }
    }
}
