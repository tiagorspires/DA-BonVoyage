package utils;

import GraphManager.Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
*
*       THIS CLASS IS DESIGNED TO EXTRACT
*
* */

public class InputReader {
    private static Graph graph;
    static Scanner reader;

    public static Graph read(String input) throws FileNotFoundException {
        File inputFile = new File(input);
        reader = new Scanner(inputFile);
        int nodesNum = reader.nextInt();
        graph = new Graph(nodesNum);
        int vehicles = reader.nextInt();
        for(int i = 0; i < vehicles; i++){
            int origin = reader.nextInt();
            int destination = reader.nextInt();
            int capacity = reader.nextInt();
            int cost = reader.nextInt();
            graph.addEdge(origin-1,destination-1, capacity, cost);
        }
        reader.close();
        return graph;
    }


    public static Graph getGraph() {
        return graph;
    }
}
