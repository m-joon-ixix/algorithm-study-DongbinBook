public class TraversingAlgorithms {
    public static void main(String[] args){
        int numOfNodes = 8;
        int[][] adjacencyGraph = {{}, {2, 3, 8}, {1, 7}, {1, 4, 5}, {3, 5}, {3, 4}, {7}, {2, 6, 8}, {1, 7}};
        int start = 1; // number of node to start at

        boolean[] visited = new boolean[numOfNodes + 1]; // for DFS

        DFS(adjacencyGraph, visited, start);
        BFS(adjacencyGraph, start);
    }

    // print the order to visit
    static void DFS(int[][] adjacencyGraph, boolean[] visited, int start){

    }

    static void BFS(int[][] adjacencyGraph, int start){

    }
}
