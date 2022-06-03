import GraphManager.Graph;

import java.util.LinkedList;

public class Cenario1a {
    static Graph solGraph;
    static int maxFlow;

    public static void execute(Graph graph,int start,int end){
        solGraph = new Graph(graph.NumVertices);
        maxFlow = maxFlow(graph,start,end);
        System.out.println(maxFlow);
        System.out.println(findPath(graph,start,end));
    }

    private static int maxFlow(Graph graph, int start, int end){
        if(start == end) return Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < graph.NumVertices; i++){
            if (graph.getWeightOnEdge(start,i) > 0){
                if (i == end){
                    solGraph.addEdge(start, i ,graph.getWeightOnEdge(start,i));
                    return graph.getWeightOnEdge(start,i);
                }
                if (solGraph.getWeightOnEdge(start,i) > 0){
                    return solGraph.getWeightOnEdge(start,i);
                }else if (solGraph.getWeightOnEdge(start,i) == -1){
                    return 0;
                }else{
                    solGraph.addEdge(start, i ,-1);
                    int temp = Math.min(graph.getWeightOnEdge(start,i), maxFlow(graph, i, end));
                    max = Math.max(temp,max);
                    solGraph.addEdge(start, i ,max);
                }
            }
        }

        return max;
    }

    private static LinkedList<Integer> findPath(Graph graph, int start, int end){
        LinkedList<Integer> path = new LinkedList<>();
        path.add(start);
        while(start != end){
            for (int i = 0; i < graph.NumVertices; i++){
                if (graph.getWeightOnEdge(start,i) >= maxFlow) {
                    start = i;
                    path.add(i);
                    break;
                }
            }
        }
        return path;
    }
}
