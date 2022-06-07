package utils;

import Cenario1.Cenario1a;
import Cenario1.Cenario1b;
import Cenario2.*;
import GraphManager.Graph;

import java.io.FileNotFoundException;
import java.util.Scanner;

/*
*
*
*       THE MENU CLASS ALLOWS US TO DISPLAY AN ASCII MENU, TO HANDLE ALL THE DATA
*
* */

public class Menu {
    static Scanner in;
    static int start = 0;
    static int end = 0;
    static Graph graph;
    static int inputFileIndex;

    /* MAIN FUNCTION IN MENU CLASS -> IT DISPLAYS THE MENU AND CALLS EVERY OTHER AUXILIARY FUNCTIONS*/
    public static void display() throws FileNotFoundException {
        in = new Scanner(System.in);
        int n;
        int size; // size of the group (required for the second scenario)

        System.out.println("-----------------------------");
        System.out.println("-------------Menu------------");
        System.out.println("-----------------------------");
        System.out.println(" [1] Inseparable group");
        System.out.println(" [2] Separable group");
        System.out.println(" [0] Exit");

        do {
            n = in.nextInt();
        } while ((n != 0) && (n != 1) && (n != 2));


        switch (n) {
            case 0 -> System.exit(0);
            case 1 -> {
                System.out.println(" Choose an option: ");
                System.out.println(" [1] Maximize group size and get a route");
                System.out.println(" [2] Maximize group size + minimize transhipments and get a route");
                System.out.println(" [3] Go Back");
                System.out.println(" [0] Exit");

                do {
                    n = in.nextInt();
                } while ((n < 0) || (n > 3));
                switch (n) {
                    case 0 -> System.exit(0);
                    case 1 -> {
                        ChooseInput();
                        Cenario1a.execute(graph, start, end);
                    }
                    case 2 -> {
                        ChooseInput();
                        Cenario1b.execute(graph, start, end);
                    }
                    case 3 -> Menu.display();
                }
            }
            case 2 -> {
                System.out.println(" Choose an option: ");
                System.out.println(" [1] Determine a route for a group, given its size");
                System.out.println(" [2] Determine the maximum group size and a route");
                System.out.println(" [3] Starting from a route that constitutes an acyclic graph, determine when the\n group would meet again at the destination at least");
                System.out.println(" [0] Go back");

                do {
                    n = in.nextInt();
                } while ((n < 0) || (n > 4));

                switch (n) {
                    case 0 -> Menu.display();
                    case 1 -> {
                        ChooseInput();
                        System.out.println("Group size: ");
                        size = in.nextInt();
                        Cenario2a.execute(graph, start, end, size);
                        ChooseCenario2b(size);
                    }
                    case 2 -> {
                        ChooseInput();
                        Cenario2c.execute(graph, start, end);
                    }
                    case 3 -> {
                        ChooseInput();
                        Cenario2d.execute(graph, start, end);
                    }
                }
            }
        }
        display();
    }

    /*
        Cenario 2.2 is identical to Cenario 2.1, and it depends on the result of the last one.
        with our implementation we do not need to do any additional computation to obtain the result we need.
        Our solution is to simply re-apply the algorithm on 2.1 with an increased group size. Something that would be different if we used other algorithms like
        Dijkstra ( there would be more optimized alternatives to it)
     */
    private static void ChooseCenario2b(int size) throws FileNotFoundException {
        int choice;
        do {
            System.out.println("Do you Want to Increase the group size?\n[0] no\n[1] yes");
            choice = in.nextInt();
        } while ((choice != 0) && (choice != 1));
        if (choice==1){
            System.out.println("How many more people do you want to take?");
            int increase = in.nextInt();
            String file = "Input/in" + inputFileIndex + ".txt";
            Graph g =  InputReader.read(file);
            Cenario2a.execute(g,start,end,size+increase);
        }
    }

    /* calls for Inputs from the user */
    private static void ChooseInput() throws FileNotFoundException{
        String file;
        do {
            System.out.println("Choose from file 1 to 10");
            inputFileIndex = in.nextInt();
        } while ((inputFileIndex < 1) || (inputFileIndex > 10));
        file = "Input/in" + inputFileIndex + ".txt";
        graph = InputReader.read(file);
        System.out.println("Choose a start");
        start = in.nextInt();
        System.out.println("Choose a destination");
        end = in.nextInt();
    }
}
