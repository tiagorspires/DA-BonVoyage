package Cenario2;

import GraphManager.Edge;
import GraphManager.Graph;

import java.util.LinkedList;
import java.util.List;


import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;

public class Cenario2a {
    static Graph solGraph;
    static int maxFlow;
    static LinkedList<Integer> path;

    public static void execute(Graph graph,int start,int end, int size){
        solGraph = new Graph(graph.NumVertices);
        forwardGroup(graph,start,end,size);
    }

    private static void forwardGroup(Graph graph, int start, int end, int size) {
        LinkedList<LinkedList<Integer>> multiRoutes = new LinkedList<>();
        while(size>0){
            int maxFlow = maxFlow(graph,start,end);
            LinkedList<Integer> singleRoute;
            singleRoute = findPath(graph,start,end);
            multiRoutes.add(singleRoute);
            purgePath(singleRoute, maxFlow);
            size -= maxFlow;
        }

    }

    private static void purgePath(LinkedList<Integer> singleRoute, int maxFlow) {

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
                if (solGraph.getWeightOnEdge(start,i.getDestination()) > 0){
                    return solGraph.getWeightOnEdge(start,i.getDestination());
                }else if (solGraph.getWeightOnEdge(start,i.getDestination()) == -1){
                    return 0;
                }else{
                    solGraph.addEdge(start, i.getDestination() ,-1);
                    int temp = Math.min(i.getWeight(), maxFlow(graph, i.getDestination(), end));
                    max = Math.max(temp,max);
                    solGraph.addEdge(start, i.getDestination() ,max);
                }
            }
        }

        return max;
    }

    private static LinkedList<Integer> findPath(Graph graph, int start, int end){
        path = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        path.add(start);
        int maximo = MAX_VALUE;
        if(start != end){
            for (int i = 0;i < graph.NumVertices;i++){
                if (graph.getWeightOnEdge(start,i) >= maxFlow) {
                    LinkedList<Integer> temp = findPath(graph,i,end);
                    if (temp.size() < maximo){
                        max = temp;
                        maximo = temp.size();
                    }
                }
            }
            path.addAll(max);
        }
        return path;
    }
}

