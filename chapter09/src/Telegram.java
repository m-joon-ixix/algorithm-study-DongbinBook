/*
Problem 9-3 : Telegram from city to city
*/

import java.util.*;

public class Telegram {
    static List<List<Edge>> adjacencyGraph; // adjacencyGraph.get(i): List of edges starting at i
    static int n; // number of cities
    static int c; // starting point

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        printAdjacencyGraph(); // for debugging

        int[] distanceTable = dijkstra(c);

        int maxTime = 0, count = 0;
        for(int city = 1; city <= n; city++){
            if(city == c) continue;
            if(distanceTable[city] < Integer.MAX_VALUE){
                // if the signal reaches this city
                count++;
                if(maxTime < distanceTable[city]) maxTime = distanceTable[city];
            }
        }

        System.out.println(count + " " + maxTime);
    }

    static int[] dijkstra(int start){
        // returns an array that contains times needed to arrive to each city (starting at 'start')
        int[] distance = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            distance[i] = Integer.MAX_VALUE; // INF distance
        }
        distance[start] = 0;
        PriorityQueue<NodeWithDist> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new NodeWithDist(0, start));

        int node, dist, newDist;
        NodeWithDist nodeWithDist;
        while(!priorityQueue.isEmpty()){
            nodeWithDist = priorityQueue.poll();
            node = nodeWithDist.nodeNumber;
            dist = nodeWithDist.distance; // distance until this node
            if(distance[node] < dist) continue; // if this node was already updated before, skip

            for(Edge edge : adjacencyGraph.get(node)){
                // edge: an edge that starts at 'node'
                newDist = dist + edge.timeNeeded;
                if(newDist < distance[edge.destination]){
                    distance[edge.destination] = newDist;
                    priorityQueue.add(new NodeWithDist(newDist, edge.destination));
                }
            }
        }

        return distance;
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 30000 || m < 1 || m > 200000 || c < 1 || c > n) return false;

        adjacencyGraph = new ArrayList<>(n + 1);
        for(int i = 0; i < n + 1; i++){
            adjacencyGraph.add(new ArrayList<>());
        }

        int x, y, z;
        for(int i = 0; i < m; i++){
            // get the edge information from each line, and store the info to adjacencyGraph
            x = sc.nextInt(); y = sc.nextInt(); z = sc.nextInt();
            sc.nextLine();
            if(x < 1 || x > n || y < 1 || y > n || z < 1 || z > 1000) return false;
            adjacencyGraph.get(x).add(new Edge(y, z));
        }

        return true;
    }

    static void printAdjacencyGraph(){
        for(int i = 1; i < adjacencyGraph.size(); i++){
            System.out.print("Departing at " + i + ": ");
            for(Edge edge : adjacencyGraph.get(i)){
                System.out.print("(dest: " + edge.destination + ", distance: " + edge.timeNeeded + ")  ");
            }
            System.out.println();
        }
    }
}

class Edge{
    int destination;
    int timeNeeded;

    Edge(int destination, int timeNeeded){
        this.destination = destination;
        this.timeNeeded = timeNeeded;
    }
}

class NodeWithDist implements Comparable<NodeWithDist>{
    int distance;
    int nodeNumber;

    NodeWithDist(int distance, int nodeNumber){
        this.distance = distance;
        this.nodeNumber = nodeNumber;
    }

    @Override
    public int compareTo(NodeWithDist other){
        if(this.distance > other.distance) return 1;
        else if(this.distance == other.distance) return 0;
        else return -1;
    }
}