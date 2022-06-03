package utils;

import GraphManager.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class InputReader {
    private static ArrayList<Vehicle> vehicleList;
    private static Graph graph;
    static Scanner reader;

    public static void read(String input) throws FileNotFoundException {
        File inputFile = new File(input);
        reader = new Scanner(inputFile);
        int nodesNum = reader.nextInt();
        graph = new Graph(nodesNum);
        vehicleList = new ArrayList<>();
        int vehicles = reader.nextInt();
        for(int i = 0; i < vehicles; i++){
            int origin = reader.nextInt();
            int destination = reader.nextInt();
            int capacity = reader.nextInt();
            int cost = reader.nextInt();
            vehicleList.add(new Vehicle(origin, destination, capacity, cost));
            graph.addEdge(origin-1,destination-1, capacity);
        }
        reader.close();
    }

    public static ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public static Graph getGraph() {
        return graph;
    }
}
