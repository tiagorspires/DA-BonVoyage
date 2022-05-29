public class Cenario1a {
    static int[][] solGraph;

    public static int execute(int[][] graph,int start,int end){
        if(start == end) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < graph.length;i++){

            if (graph[start][i] > 0){
                if (solGraph[start][i] > 0){
                    return solGraph[start][i];
                }
                if (i == end){
                    solGraph[start][i] = graph[start][i];
                    return graph[start][i];
                }

                min = Math.min(min, execute(graph,i,end));
                solGraph[start][i] = Math.max(min, execute(graph,i,end));

            }
        }

        return min;
    }
}
