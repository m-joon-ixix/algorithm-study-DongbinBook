/*
Problem 10-3: Making Teams - Kruskal Algorithm (p.300) - Baekjoon Online Judge Problem (1647)
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class CityPartitionPlan {
    static int n;
    static List<Road> roads = new ArrayList<>();

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        int[] parentTable = new int[n + 1]; // parentTable[i]: root node of city i
        for(int i = 1; i <= n; i++) parentTable[i] = i;

        Collections.sort(roads); // to seek for minimum cost roads first

        // roadsToLeave: roads consisting minimum spanning tree
        List<Road> roadsToLeave = new ArrayList<>();
        for(Road road : roads){
            if(findParent(parentTable, road.house1) != findParent(parentTable, road.house2)){
                roadsToLeave.add(road);
                unionParent(parentTable, road.house1, road.house2);
            }
        }

        Collections.sort(roadsToLeave); // ascending order in cost
        roadsToLeave.remove(roadsToLeave.size() - 1); // remove the most expensive road, to partition the city

        int sumOfCosts = 0;
        for(Road road : roadsToLeave) sumOfCosts += road.cost;

        System.out.println(sumOfCosts);
    }

    static int findParent(int[] parentTable, int x){
        // find the root node of node x
        if(parentTable[x] != x) parentTable[x] = findParent(parentTable, parentTable[x]);
        return parentTable[x];
    }

    static void unionParent(int[] parentTable, int a, int b){
        int rootOfA = findParent(parentTable, a);
        int rootOfB = findParent(parentTable, b);
        if(rootOfA < rootOfB) parentTable[rootOfB] = rootOfA;
        else parentTable[rootOfA] = rootOfB;
    }


    static boolean getInput(){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        if(n < 2 || n > 100000 || m < 1 || m > 1000000) return false;

        int a, b, c;
        for(int i = 0; i < m; i++){
            // get the m roads from input
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            if(c < 1 || c > 1000) return false;
            roads.add(new Road(a, b, c));
            scanner.nextLine();
        }

        return true;
    }
}

class Road implements Comparable<Road>{
    int house1;
    int house2;
    int cost;

    Road(int h1, int h2, int cost){
        this.house1 = h1;
        this.house2 = h2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road other){
        return Integer.compare(this.cost, other.cost);
    }
}