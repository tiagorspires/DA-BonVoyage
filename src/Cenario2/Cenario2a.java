package Cenario2;

import GraphManager.Edge;
import GraphManager.Graph;

import java.util.LinkedList;
import java.util.List;

/*

 */


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

    /* designed to find a multi-route for a group ( containing more than a route)
    * it finds the route which has the max flow and then forwards a part of the group. it purges the capacity of that route
    * and then repeats the process again until there is no one left or there is no room for anyone else */
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

    /*
        designed to exhaust a path so there is no chance of forwarding someone via the same path
     */
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


    /*
        This function finds the max flow on a single route in the graph
     */
    private static int maxFlow(Graph graph, int start, int end){
        if(start == end) return Integer.MAX_VALUE;
        int max = 0;
        List<Edge> EdgeList = graph.getEdgeList(start);
        for (Edge i :EdgeList){
            if (i.getWeight() > 0){
                // if the destination is the end it returns the weight
                if (i.getDestination() == end){
                    solGraph.addEdge(start, i.getDestination() ,i.getWeight());
                    return i.getWeight();
                }
                //if the solgraph weight is bigger than zero it means it has already been computed
                if (solGraph.getWeightOnEdge(start,i.getDestination()) > 0){
                    return solGraph.getWeightOnEdge(start,i.getDestination());
                //if the solgraph weight is equal to -1 it means that the algo has reached a cycle and returns 0
                }else if (solGraph.getWeightOnEdge(start,i.getDestination()) == -1){
                    return 0;
                }else{
                    //sets it to -1 to show that it already has been visited
                    solGraph.addEdge(start, i.getDestination() ,-1);
                    //temp is equal to the weight of the route to show bottlenecks
                    int temp = Math.min(i.getWeight(), maxFlow(graph, i.getDestination(), end));
                    //the max of all the paths
                    max = Math.max(temp,max);
                    //adds the edge with the value that the route can take
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

