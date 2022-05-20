import java.util.ArrayList;

public class BonVoyage {
    public static int Nodes_num; // number of nodes
    public static ArrayList<Vehicle> vehicleList;

    public static void main(String[] args) {
        vehicleList = new ArrayList<Vehicle>();
        Menu.displayMenu();
        for (Vehicle v: vehicleList) {
            System.out.println(v);
        }
        System.out.println(vehicleList.size());
    }
}
