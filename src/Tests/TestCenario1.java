package Tests;

import Cenario1.Cenario1b;
import GraphManager.Graph;

public class TestCenario1 {
    int start = 0;
    int end = 5;

    public static void Execute(){
        Graph graph = new Graph(6);
        /*
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,3);
        graph.addEdge(1,3,5);
        graph.addEdge(2,1,3);
        graph.addEdge(2,4,3);
        graph.addEdge(3,2,2);
        graph.addEdge(3,4,4);
        */
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,4);
        graph.addEdge(1,3,3);
        graph.addEdge(2,4,2);
        graph.addEdge(3,5,3);
        graph.addEdge(4,5,3);


        //System.out.println("Returned values");
        Cenario1b.execute(graph,0,5);
        //System.out.println(Cenario1a.getMaxFlow());
        //System.out.println(Cenario1a.getPath());
        System.out.println("Expected Values");
        System.out.println("[0, 1, 3, 5]");
        System.out.println("3");


    }

}
