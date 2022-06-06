package Cenario1;

import GraphManager.Edge;
import GraphManager.Graph;

import java.util.LinkedList;
import java.util.List;

public class Cenario1a {
    static Graph solGraph;
    static int maxFlow;
    static LinkedList<Integer> path;

    public static void execute(Graph graph,int start,int end){
        solGraph = new Graph(graph.NumVertices);
        maxFlow = maxFlow(graph,start,end);
        System.out.println("Maxflow: " + maxFlow);
       if (maxFlow > 0){
           path = findPath(solGraph,start,end);
           System.out.println("Path: " + path);
       }

    }


    private static int maxFlow(Graph graph, int start, int end){
        if(start == end) return Integer.MAX_VALUE;
        int max = 0;

        List<Edge> EdgeList = graph.getEdgeList(start);

        for (Edge i :EdgeList){
            if (i.getWeight() > 0){
                if (i.getDestination() == end){
                    solGraph.addEdge(start, i.getDestination() ,i.getWeight());
                    return i.getWeight();
                }
                if (solGraph.getWeightOnEdge(start,i.getDestination()) >= 0){
                    return solGraph.getWeightOnEdge(start,i.getDestination());
                }else if (solGraph.getWeightOnEdge(start,i.getDestination()) == -1){
                    return 0;
                }else{
                    solGraph.addEdge(start, i.getDestination() ,-1);
                    int temp = Math.min(i.getWeight(), maxFlow(graph, i.getDestination(), end));
                    max = Math.max(temp,max);
                    solGraph.addEdge(start, i.getDestination() ,temp);
                }
            }
        }

        return max;
    }

    private static LinkedList<Integer> findPath(Graph graph, int start, int end){

        LinkedList<Integer> path = new LinkedList<>();
        path.add(start);
        List<Edge> graphEdgeList = graph.getEdgeList(start);
        while(start != end){
            for (Edge i:graphEdgeList){
                if (i.getWeight() >= maxFlow) {
                    start = i.getDestination();
                    path.add(i.getDestination());
                    graphEdgeList = graph.getEdgeList(i.getDestination());
                    break;
                }
            }
        }
        return path;
    }

    public static int getMaxFlow() {
        return maxFlow;
    }

    public static LinkedList<Integer> getPath() {
        return path;
    }
}
