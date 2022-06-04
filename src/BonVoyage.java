import Cenario1.*;
import GraphManager.Graph;
import utils.Vehicle;

import java.util.ArrayList;

public class BonVoyage {
    public static ArrayList<Vehicle> vehicleList;
    public static Graph graph;
    static Test test = new Test();


    public static void main(String[] args) {
        vehicleList = new ArrayList<>();
        //utils.Menu.displayMenu();


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

        Test.Execute();
    }

}
