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

        Cenario1a.solGraph = new int[5][5];
        for (int i = 0;i < 5;i++){
            for (int j = 0;j <5;j++){
                Cenario1a.solGraph[i][j] = 0;
            }
        }
        System.out.println(Cenario1a.execute(graph,0,7));


    }
}
