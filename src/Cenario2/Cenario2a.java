package Cenario2;

import GraphManager.Edge;
import GraphManager.Graph;

import java.util.LinkedList;
import java.util.List;


import static java.lang.Integer.MAX_VALUE;

public class Cenario2a {
    static Graph solGraph;
    static int maxFlow;
    static LinkedList<Integer> path;
    static LinkedList<LinkedList<Integer>> multiRoutes;
    static Graph graph;

    public static void execute(Graph graph,int start,int end, int size){
        solGraph = new Graph(graph.NumVertices);
        multiRoutes = new LinkedList<>();
        forwardGroup(graph,start,end,size);
        System.out.println(multiRoutes);
    }

    private static void forwardGroup(Graph graph, int start, int end, int size) {
        do{
            maxFlow = maxFlow(graph,start,end); // it searches the max flow single route to forward a section of the group
            LinkedList<Integer> singleRoute;
            if(maxFlow>0) {
                singleRoute = findPath(solGraph, start, end); // then it extracts the single path obtained and inserts it into the multi route
                multiRoutes.add(singleRoute);
                purgePath(graph,singleRoute, maxFlow); // purges the single route obtained so it can not be chosen again in the next iteration of this function
                size -= maxFlow;
                solGraph = new Graph(graph.NumVertices);
            }
        }while(size>0 && maxFlow > 0 );
    }

    private static void initSolGraph(int numVertices) {

    }

    private static void purgePath(Graph graph,LinkedList<Integer> singleRoute, int maxFlow) {
        List<Edge> mylist = graph.getEdgeList(singleRoute.get(0));

        //converted list to array to get constant complexity when getting a value
        int[] route = new int[singleRoute.size()];
        int a = 0;
        for (int i:singleRoute) {
            route[a] = i;
            a++;
        }

        for (int i = 0;i < route.length-1;i++){
            for (Edge e: mylist) {
                if (e.getDestination() == route[i+1]){
                    e.setWeight(e.getWeight()-maxFlow);
                }
            }
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
}

