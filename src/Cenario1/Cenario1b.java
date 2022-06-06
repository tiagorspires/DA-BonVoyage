package Cenario1;
import GraphManager.Edge;
import GraphManager.Graph;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Cenario1b {

    static Graph solGraph;
    static int maxFlow;
    static int max1 = 0;


    public static void execute(Graph graph, int start, int end) {
        solGraph = new Graph(graph.NumVertices);
        maxFlow = maxFlow(graph, start, end);
        //System.out.println(maxFlow);
        solGraph(start,end,MAX_VALUE);
        LinkedList<Integer> a = findMaxValuePath(solGraph, start, end);
        LinkedList<Integer> b = findMinTransbordPath(solGraph, start, end);

        if(b.size()==a.size()) {
                System.out.println("MaxFlow: " + maxFlow);
                System.out.println("Numero de transbordos: " + (a.size() - 1));
                System.out.println("Path" + a);
        }else if ((maxFlow == max1)){
                System.out.println("MaxFlow: " + max1);
                System.out.println("Numero de transbordos: " + (b.size() - 1));
                System.out.println("Path" + b);
            } else {
                System.out.println("MaxFlow: " + max1);
                System.out.println("Numero de transbordos: " + (b.size() - 1));
                System.out.println("Path" + b);
                System.out.println("");
                System.out.println("MaxFlow: " + maxFlow);
                System.out.println("Numero de transbordos: " + (a.size() - 1));
                System.out.println("Path" + a);

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
                    solGraph.addEdge(start, i.getDestination() ,temp);
                }
            }
        }

        return max;
    }

    private static void solGraph(int start,int end,int min){
        if (start == end)return;
        List<Edge> EdgeList = solGraph.getEdgeList(start);
        for (Edge i :EdgeList){
            if (i.getWeight() > 0) {
                i.setWeight(Math.min(i.getWeight(), min));
                solGraph(i.getDestination(), end, Math.min(min, i.getWeight()));
            }
        }
    }

    private static LinkedList<Integer> findMaxValuePath(Graph graph, int start, int end) {
        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        List<Edge> edges = graph.getEdgeList(start);
        path.add(start);
        int maximo = MAX_VALUE;
        if (start != end) {
            for (Edge i:edges) {
                if (i.getWeight() >= maxFlow) {
                    LinkedList<Integer> temp = findMaxValuePath(graph, i.getDestination(), end);
                    if (temp.size() < maximo) {
                        max = temp;
                        maximo = temp.size();
                    }

                }
            }
            path.addAll(max);
        }
        return path;
    }


    private static LinkedList<Integer> findMinTransbordPath(Graph graph, int start, int end) {
        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();
        List<Edge> edges = graph.getEdgeList(start);

        int minSize = MAX_VALUE;
        path.add(start);
        if (start != end) {
            for (Edge i:edges) {
                if (i.getWeight() > 0) {

                    LinkedList<Integer> temp = findMinTransbordPath(graph, i.getDestination(), end);
                    if (temp.size() < minSize){
                        max1= i.getWeight();
                        minSize = temp.size();
                        min = temp;
                    }
                    if(temp.size() == minSize && max1 < i.getWeight()){
                        min = temp;
                    }
                }
            }
        }
        path.addAll(min);

        return path;
    }
}



