import GraphManager.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader {
    static Scanner reader;
    public static void read(String input) throws FileNotFoundException {
        File inputFile = new File(input);
        reader = new Scanner(inputFile);
        BonVoyage.Nodes_num = reader.nextInt();
        BonVoyage.graph = new Graph(BonVoyage.Nodes_num);
        int vehicles = reader.nextInt();
        for(int i = 0; i < vehicles; i++){
            int origin = reader.nextInt();
            int destiny = reader.nextInt();
            int capacity = reader.nextInt();
            int cost = reader.nextInt();
            BonVoyage.vehicleList.add(new Vehicle(origin, destiny, capacity, cost));
            BonVoyage.graph.addEdge(origin,destiny,capacity);

        }
        reader.close();
    }
}
