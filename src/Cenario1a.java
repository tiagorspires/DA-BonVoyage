public class Cenario1a {
    static int[][] solGraph;

    public static int execute(int[][] graph,int start,int end){
        if(start == end) return Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0;i < graph.length;i++){
            if (graph[start][i] > 0){
                if (i == end){
                    solGraph[start][i] = graph[start][i];
                    return graph[start][i];
                }
                if (solGraph[start][i] > 0){
                    max = Math.max(solGraph[start][i],max);
                }else{
                    max = Math.max(Math.min(graph[start][i], execute(graph, i, end)),max);
                    solGraph[start][i] = max;
                }
            }
        }

        return max;
    }
}
