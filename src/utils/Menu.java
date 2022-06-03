package utils;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    static Scanner stdin;
    public static void displayMenu(){
        stdin = new Scanner(System.in);
        System.out.println("1 - Cenário 1 \n2 - Cenário 2");
        int scenario = stdin.nextInt();
        System.out.println("Choose from file 1 to 10");
        int inputFileIndex = stdin.nextInt();
        String inputFile = "Input/in" + inputFileIndex + ".txt";
        System.out.println(inputFile);
        try {
            InputReader.read(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
