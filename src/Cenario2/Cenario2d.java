package Cenario2;

import GraphManager.Edge;
import GraphManager.Graph;

import java.util.LinkedList;
import java.util.List;

public class Cenario2d {
    static Graph solGraph;
    static int maxFlow;
    static LinkedList<Integer> path;
    static LinkedList<LinkedList<Integer>> multiRoutes;
    static Graph graph;

    public static void execute(Graph graph,int start,int end){
        solGraph = new Graph(graph.NumVertices);
        multiRoutes = new LinkedList<>();
        System.out.println("The larger Group we can accept for this destination is: " + forwardGroup(graph,start,end));
        System.out.println("And here is the itinerary: " + multiRoutes);
        System.out.println(meeting(graph, multiRoutes));
    }

    private static int meeting(Graph graph, LinkedList<LinkedList<Integer>> routes) {
        int min = 0;
        for (LinkedList<Integer> route: routes) {
            min = Math.max(min,findRouteDuration(graph,route));
        }
        return min;
    }

    private static int findRouteDuration(Graph graph, LinkedList<Integer> route) {
        int counter = 0;
        for(int j = 0; j < route.size();j++){
            List<Edge> mylist = graph.getEdgeList(route.get(j));

            int[] path = new int[route.size()];
            int a = 0;
            for (int i:route) {
                path[a] = i;
                a++;
            }

            for (int i = 0;i < path.length-1;i++){
                for (Edge e: mylist) {
                    if (e.getDestination() == path[i+1]){
                        counter += e.getDeuration();
                    }
                }
            }
        }
        return counter;
    }

    private static int forwardGroup(Graph graph, int start, int end) {
        int counter = 0;
        do{
            maxFlow = maxFlow(graph,start,end); // it searches the max flow single route to forward a section of the group
            if(maxFlow>0) {
                LinkedList<Integer> singleRoute = findPath(solGraph, start, end); // then it extracts the single path obtained and inserts it into the multi route
                multiRoutes.add(singleRoute);
                purgePath(graph,singleRoute, maxFlow); // purges the single route obtained, so it won't be chosen again in the next iteration of this function
                counter+=maxFlow;
                solGraph = new Graph(graph.NumVertices);
            }
        }while(maxFlow > 0 );
        return counter;
    }

    private static void purgePath(Graph graph,LinkedList<Integer> singleRoute, int maxFlow) {
        for(int j = 0; j< singleRoute.size();j++){
            List<Edge> mylist = graph.getEdgeList(singleRoute.get(j));
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

