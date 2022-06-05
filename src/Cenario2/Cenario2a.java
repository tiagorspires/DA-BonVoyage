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
    static Graph graph;

    public static void execute(Graph graph,int start,int end, int size){
        solGraph = new Graph(graph.NumVertices);
        forwardGroup(graph,start,end,size);
    }

    private static void forwardGroup(Graph graph, int start, int end, int size) {
        LinkedList<LinkedList<Integer>> multiRoutes = new LinkedList<>();
        do{
            int maxFlow = maxFlow(graph,start,end); // it searches the max flow single route to forward a section of the group
            LinkedList<Integer> singleRoute;
            singleRoute = findPath(graph,start,end); // then it extracts the single path obtained and inserts it into the multi route
            multiRoutes.add(singleRoute);
            purgePath(singleRoute, maxFlow); // purges the single route obtained so it can not be chosen again in the next iteration of this function
            size -= maxFlow;
        }while(size>0 && maxFlow > 0 );

    }

    private static void purgePath(LinkedList<Integer> singleRoute, int maxFlow) {
        List<Edge> mylist = solGraph.getEdgeList(singleRoute.get(0));

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

