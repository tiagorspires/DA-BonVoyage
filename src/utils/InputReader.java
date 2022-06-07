package utils;

import GraphManager.Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
*
*       THIS CLASS IS DESIGNED TO EXTRACT THE DATA FROM THE INPUT FILE LOCATED IN THE INPUT FOLDER
*
* */

public class InputReader {
    private static Graph graph;
    static Scanner reader;

    /* The main function of the class, it reads from the chosen file and the returns the corresponding Graph */
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
            int duration = reader.nextInt();
            graph.addEdge(origin-1,destination-1, capacity, duration);
        }
        reader.close();
        return graph;
    }


    public static Graph getGraph() {
        return graph;
    }
}
