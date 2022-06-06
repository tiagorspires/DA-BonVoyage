package Tests;

import Cenario1.Cenario1b;
import GraphManager.Graph;
/*
 *  WE CREATED THIS CLASS WITH THE PURPOSE OF TESTING OUR SCENARIO 1  WITH A SMALLER GRAPH, INSTEAD OF A LARGE GRAPH
 *  THIS WILL EASE THE DEBUGGING PROCESS
 */


public class TestCenario1 {
    int start = 0;
    int end = 6;

    public static void Execute(){
        Graph graph = new Graph(7);
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,4);
        graph.addEdge(1,3,3);
        graph.addEdge(2,4,2);
        graph.addEdge(3,5,3);
        graph.addEdge(5,6,3);
        graph.addEdge(4,6,3);


        //System.out.println("Returned values");
        Cenario1b.execute(graph,0,6);


    }

}
