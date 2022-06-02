import GraphManager.Graph;

import java.util.ArrayList;
import java.util.List;

public class BonVoyage {
    public static int Nodes_num; // number of nodes
    public static ArrayList<Vehicle> vehicleList;
    public static int[][] graph;

    public static void main(String[] args) {
        vehicleList = new ArrayList<>();
        Menu.displayMenu();

        int[][] graph= {
            {0,4,3,0,0},
            {0,0,0,5,0},
            {0,3,0,0,3},
            {0,0,2,0,4},
            {0,0,0,0,0}};

        Cenario1a.execute(graph,0,4);


    }
}
