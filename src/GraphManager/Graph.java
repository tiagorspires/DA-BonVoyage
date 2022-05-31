package GraphManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*
*  Directed and Weighted Graph
*   Each node is numbered from 1 to N (number of nodes)
* */


public class Graph {
    int vertices;
    LinkedList<Edge> [] adjacencylist;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        for (int i = 0; i <vertices ; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(destination, weight);
        adjacencylist[source].addFirst(edge); //for directed graph
    }

    public void printGraph(){
        for (int i = 0; i <vertices ; i++) {
            LinkedList<Edge> list = adjacencylist[i];
            for (int j = 0; j <list.size() ; j++) {
                System.out.println(" " + i + " ---> " +
                        list.get(j).destination + " w(" + list.get(j).weight + ")");
            }
        }
    }
}
