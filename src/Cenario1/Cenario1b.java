package Cenario1;
import GraphManager.Graph;

import java.util.LinkedList;

import static java.lang.Integer.MAX_VALUE;

public class Cenario1b {

    static Graph solGraph;
    static int maxFlow;


    public static void execute(Graph graph, int start, int end){
        solGraph = new Graph(graph.NumVertices);
        maxFlow = maxFlow(graph,start,end);
        System.out.println(maxFlow);
        LinkedList<Integer> a = findPath(graph,start,end);
        System.out.println(a);
        System.out.println(a.size()-1);
    }

    private static int maxFlow(Graph graph, int start, int end){
        if(start == end) return MAX_VALUE;
        int max = 0;
        for (int i = 0;i < graph.NumVertices;i++){

            if (graph.getWeightOnEdge(start,i) > 0){
                // if the next node is the end return the value of the branch
                if (i == end){
                    solGraph.addEdge(start,i, graph.getWeightOnEdge(start,i));
                    return  graph.getWeightOnEdge(start,i);
                }
                // if the solGraph is bigger than zero it means that the solution for the branch has already been calculated
                if (solGraph.getWeightOnEdge(start,i) > 0){
                    return solGraph.getWeightOnEdge(start,i);
                }
                //if is set to -1 it means that the branch has already been called but the solution has not been found
                //meaning that the method went in a cycle
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
        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        path.add(start);
        if(start != end){
            for (int i = 0;i < graph.NumVertices;i++){
                if (graph.getWeightOnEdge(start,i) >= maxFlow) {
                    LinkedList<Integer> temp = findPath(graph,i,end);
                    if (temp.size() < MAX_VALUE){
                        max = temp;
                    }

                }
            }
            path.addAll(max);
        }
        return path;
    }

}

