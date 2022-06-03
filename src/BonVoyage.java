import Cenario1.*;
import GraphManager.Graph;
import utils.Vehicle;

import java.util.ArrayList;

public class BonVoyage {
    public static ArrayList<Vehicle> vehicleList;
    public static Graph graph;


    public static void main(String[] args) {
        vehicleList = new ArrayList<>();
        //utils.Menu.displayMenu();


        graph = new Graph(5);
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,3);
        graph.addEdge(1,3,5);
        graph.addEdge(2,1,3);
        graph.addEdge(2,4,3);
        graph.addEdge(3,2,2);
        graph.addEdge(3,4,4);

        /*
        int[][] grapho= {
            {0,4,3,0,0},
            {0,0,0,5,0},
            {0,3,0,0,3},
            {0,0,2,0,4},
            {0,0,0,0,0}};



        graph = utils.InputReader.getGraph();
        vehicleList = utils.InputReader.getVehicleList();
        */

        Cenario1a.execute(graph,0,4);
    }

}
