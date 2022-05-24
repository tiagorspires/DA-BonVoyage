import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader {
    static Scanner reader;
    public static void read(String input) throws FileNotFoundException {
        File inputFile = new File(input);
        reader = new Scanner(inputFile);
        BonVoyage.Nodes_num = reader.nextInt();
        int vehicles = reader.nextInt();
        for(int i = 0; i < vehicles; i++){
            BonVoyage.vehicleList.add(new Vehicle(reader.next(), reader.next(), reader.nextInt(), reader.nextInt()));
        }
        reader.close();
    }
}
