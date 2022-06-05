import Cenario1.Cenario1a;
import GraphManager.Edge;
import GraphManager.Graph;

import java.util.List;

public class Test {
    int start = 0;
    int end = 4;

    public static void Execute(){
        Graph graph = new Graph(5);
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,3);
        graph.addEdge(1,3,5);
        graph.addEdge(2,1,3);
        graph.addEdge(2,4,3);
        graph.addEdge(3,2,2);
        graph.addEdge(3,4,4);

        List<Edge> bla = graph.getEdgeList(2);
        bla.get(1).setWeight(-1);

        List<Edge> bla2 = graph.getEdgeList(2);
        System.out.println(bla2);
        /*
        System.out.println("Returned values");
        Cenario1a.execute(graph,0,4);
        System.out.println(Cenario1a.getMaxFlow());
        System.out.println(Cenario1a.getPath());
        System.out.println("Expected Values");
        System.out.println("4");
        System.out.println("[0, 1, 3, 4]");

         */
    }

}
