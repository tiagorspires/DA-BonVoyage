import GraphManager.Graph;
import Tests.TestCenario1;
import Tests.TestCenario2;
import utils.Vehicle;

import java.util.ArrayList;

public class BonVoyage {
    public static ArrayList<Vehicle> vehicleList;
    public static Graph graph;

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
        System.out.println("Testing Scenario 1");
        System.out.println("");
        TestCenario1.Execute();
        System.out.println("-------------------");
        //System.out.println("Testing Scenario 2");
        //TestCenario2.Execute();
    }

}
