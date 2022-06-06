package Tests;

import Cenario1.Cenario1a;
import Cenario1.Cenario1b;
import Cenario2.Cenario2a;
import Cenario2.Cenario2c;
import Cenario2.Cenario2d;
import GraphManager.Edge;
import GraphManager.Graph;

import java.util.List;

public class TestCenario2 {
    int start = 0;
    int end = 5;

    public static void Execute(){
        Graph graph = new Graph(6);
        /*
        test case for cenario 1b
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,3);
        graph.addEdge(1,3,5);
        graph.addEdge(2,1,3);
        graph.addEdge(2,4,3);
        graph.addEdge(3,2,2);
        graph.addEdge(3,4,4);
        */
        graph.addEdge(0,1,4, 4);
        graph.addEdge(0,2,4, 5);
        graph.addEdge(1,3,3, 1);
        graph.addEdge(2,4,2, 6);
        graph.addEdge(3,5,3, 7);
        graph.addEdge(4,5,3, 3);



        Cenario2d.execute(graph,0,5);
        System.out.println("Expected Values");
        System.out.println("5");
        System.out.println("[[0, 1, 3, 5], [0, 2, 4, 5]]");



    }

}
