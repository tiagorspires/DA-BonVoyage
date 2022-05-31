import GraphManager.Graph;

import java.util.ArrayList;
import java.util.List;

public class BonVoyage {
    public static int Nodes_num; // number of nodes
    public static ArrayList<Vehicle> vehicleList;
    public static Graph graph;

    public static void main(String[] args) {
        /*
        vehicleList = new ArrayList<>();
        Menu.displayMenu();
        for (Vehicle v: vehicleList) {
            System.out.println(v);
        }
         */


        int[][] graph ={
                {0,4,0,0},
                {0,0,4,3},
                {0,0,0,0},
                {0,0,3,0}
        };
        Cenario1a.solGraph = new int[4][4];
        for (int i = 0;i < 4;i++){
            for (int j = 0;j < 4;j++){
                Cenario1a.solGraph[i][j] = 0;
            }
        }
        System.out.println(Cenario1a.execute(graph,0,2));


    }
}
