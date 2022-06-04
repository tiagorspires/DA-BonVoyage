package Cenario2;

import Cenario1.Cenario1b;
import GraphManager.Graph;

import java.util.LinkedList;


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
        if(start == end) return MAX_VALUE;
        int max = 0;
        for (int i = 0;i < graph.NumVertices;i++){
            //checking if there is a connection 'start' --> 'i'
            if (graph.getWeightOnEdge(start,i) > 0){
                // if the next node is the end return the value of the branch
                if (i == end){
                    solGraph.addEdge(start,i, graph.getWeightOnEdge(start,i));
                    return graph.getWeightOnEdge(start,i);
                }
                // if the solGraph is bigger than zero it means that the solution for the branch has already been calculated
                if (solGraph.getWeightOnEdge(start,i) > 0){
                    return solGraph.getWeightOnEdge(start,i);
                }
                //if is set to -1 it means that the branch has already been called but the solution has not been found
                //meaning that the method went in a cycle || the graph is cyclic
                else if (solGraph.getWeightOnEdge(start,i) == -1){
                    return 0;
                }else{
                    solGraph.addEdge(start,i,-1);
                    int temp = Math.min(graph.getWeightOnEdge(start,i), maxFlow(graph, i, end));
                    max = Math.max(temp,max);
                    solGraph.addEdge(start,i,max);
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

