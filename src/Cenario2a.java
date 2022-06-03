import java.util.LinkedList;


import static java.lang.Integer.MAX_VALUE;

public class Cenario2a {
    static int[][] solGraph;
    static int maxFlow;
    LinkedList<Integer> path;

    public static void execute(int[][] graph,int start,int end){
        initSolGraph(graph.length);
        maxFlow = maxFlow(graph,start,end);
        System.out.println(maxFlow);
        System.out.println(findPath(graph,start,end));
    }

    private static void initSolGraph(int size) {
        solGraph = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                solGraph[i][j] = 0;
            }
        }
    }

    private static int maxFlow(int[][] graph, int start, int end){
        if(start == end) return MAX_VALUE;
        int max = 0;
        for (int i = 0;i < graph.length;i++){
            //checking if there is a connection 'start' --> 'i'
            if (graph[start][i] > 0){
                // if the next node is the end return the value of the branch
                if (i == end){
                    solGraph[start][i] = graph[start][i];
                    return graph[start][i];
                }
                // if the solGraph is bigger than zero it means that the solution for the branch has already been calculated
                if (solGraph[start][i] > 0){
                    return solGraph[start][i];
                }
                //if is set to -1 it means that the branch has already been called but the solution has not been found
                //meaning that the method went in a cycle || the graph is cyclic
                else if (solGraph[start][i] == -1){
                    return 0;
                }else{
                    solGraph[start][i] = -1;
                    int temp = Math.min(graph[start][i], maxFlow(graph, i, end));
                    max = Math.max(temp,max);
                    solGraph[start][i] = max;
                }
            }
        }

        return max;
    }

    private static LinkedList<Integer> findPath(int[][] graph, int start, int end){
        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        int size = MAX_VALUE;
        path.add(start);
        if(start != end){
            for (int i = 0;i < graph.length;i++){
                if (graph[start][i] >= maxFlow) {
                    LinkedList<Integer> temp = findPath(graph,i,end);
                    if (temp.size() < size){
                        max = temp;
                    }

                }
            }
            path.addAll(max);
        }

        return path;
    }
}

