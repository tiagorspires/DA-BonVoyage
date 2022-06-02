import java.util.LinkedList;

public class cenario1b {

    static int[][] solGraph;
    static int maxFlow;

    public static void execute(int[][] graph,int start,int end){
        maxFlow = maxFlow(graph,start,end);
        findPath(graph,start,end);
    }

    private static int maxFlow(int[][] graph, int start, int end){
        if(start == end) return Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0;i < graph.length;i++){
            if (graph[start][i] > 0){
                if (i == end){
                    solGraph[start][i] = graph[start][i];
                    return graph[start][i];
                }
                if (solGraph[start][i] > 0){
                    return solGraph[start][i];
                }else if (solGraph[start][i] == -1){
                    return 0;
                }else{
                    solGraph[start][i] = -1;
                    int temp = Math.min(graph[start][i], maxFlow(graph, i, end));
                    solGraph[start][i] = max;
                    max = Math.max(temp,max);
                }
            }
        }

        return max;
    }

    private static LinkedList<Integer> findPath(int[][] graph, int start, int end){
        LinkedList<Integer> path = new LinkedList<>();
        path.add(start);
        while(start != end){
            for (int i = 0;i < graph.length;i++){
                if (graph[start][i] >= maxFlow) {
                    start = i;
                    path.add(i);
                    break;
                }
            }
        }
        return path;
    }

    private static void initSolGraph(int start, int end) {
        solGraph = new int[BonVoyage.Nodes_num][BonVoyage.Nodes_num];
        //while (start)
    }

}
