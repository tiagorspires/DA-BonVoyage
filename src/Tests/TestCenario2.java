package Tests;

import GraphManager.Graph;

/*
 *  WE CREATED THIS CLASS WITH THE PURPOSE OF TESTING OUR SCENARIO 2  WITH A SMALLER GRAPH, INSTEAD OF A LARGE GRAPH
 *  THIS WILL EASE THE DEBUGGING PROCESS
 */

public class TestCenario2 {
    int start = 0;
    int end = 5;

    public static void Execute(){
        Graph graph = new Graph(6);

        graph.addEdge(0,1,4, 4);
        graph.addEdge(0,2,4, 5);
        graph.addEdge(1,3,3, 1);
        graph.addEdge(2,4,2, 6);
        graph.addEdge(3,5,3, 7);
        graph.addEdge(4,5,3, 3);
        graph.addEdge(1,4,2,3);

        System.out.println("Expected Values");
        System.out.println("5");
        System.out.println("[[0, 1, 3, 5], [0, 2, 4, 5]]");

    }
}
