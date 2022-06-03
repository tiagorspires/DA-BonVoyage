import GraphManager.Graph;

import java.util.ArrayList;
import java.util.List;

public class BonVoyage {
    public static int Nodes_num; // number of nodes
    public static ArrayList<Vehicle> vehicleList;
    public static int[][] grapho;
    public static Graph graph;


    public static void main(String[] args) {
        vehicleList = new ArrayList<>();
        //Menu.displayMenu();

        graph = new Graph(5);
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,3);
        graph.addEdge(1,3,5);
        graph.addEdge(2,1,3);
        graph.addEdge(2,4,3);
        graph.addEdge(3,2,2);
        graph.addEdge(3,4,4);

        int[][] grapho= {
            {0,4,3,0,0},
            {0,0,0,5,0},
            {0,3,0,0,3},
            {0,0,2,0,4},
            {0,0,0,0,0}};

        //Cenario1a.execute(graph,0,4);
        Cenario2a.execute(graph,0,4);


    }
}
