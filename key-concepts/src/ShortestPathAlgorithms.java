public class ShortestPathAlgorithms {
    public static void main(String[] args){

    }

    // returns table with min. distance to all nodes, departing at node 'start'
    static int[] dijkstra(int[][] adjacencyGraph, int numOfNodes, int start){
        return new int[numOfNodes + 1];
    }

    // returns n * n table containing min. distances from all nodes to each other
    static int[][] floydWarshall(int numOfNodes, Edge[] edges){
        return new int[numOfNodes + 1][numOfNodes + 1];
    }
}

class Edge {
    int origin;
    int dest;
    int distance;
}
