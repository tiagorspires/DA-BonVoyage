import GraphManager.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    static Scanner reader;
    public static void read(String input) throws FileNotFoundException {
        File inputFile = new File(input);
        reader = new Scanner(inputFile);
        BonVoyage.Nodes_num = reader.nextInt();
        int vehicles = reader.nextInt();
        BonVoyage.graph = new int[BonVoyage.Nodes_num][BonVoyage.Nodes_num];
        for(int i = 0; i < vehicles; i++){
            int origin = reader.nextInt();
            int destiny = reader.nextInt();
            int capacity = reader.nextInt();
            int cost = reader.nextInt();
            BonVoyage.vehicleList.add(new Vehicle(origin, destiny, capacity, cost));
            BonVoyage.graph[origin-1][destiny-1] = capacity;
        }
        reader.close();
    }
}
