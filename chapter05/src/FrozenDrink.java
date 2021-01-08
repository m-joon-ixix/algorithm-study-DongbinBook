/*
Problem 5-3 : Freezing Drinks (p.149)
*/

import java.util.Scanner;

public class FrozenDrink {
    static int[][] graph;

    public static void main(String[] args){
        getGraphInfo();
        int result = 0; // number of ice-creams made
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(dfs(i, j)) result++;
            }
        }
        System.out.println("Final Result: " + result);
    }

    static void getGraphInfo(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();
        if(n < 1 || n > 1000 || m < 1 || m > 1000){
            System.out.println("Invalid Input!");
            return;
        }
        graph = new int[n][m];
        String lineStr;
        for(int i = 0; i < n; i++){
            lineStr = scanner.nextLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = lineStr.charAt(j) - '0';
            }
        }
    }

    // DFS starting at row i, column j, returns true if DFS was successful
    // if block is visited, make the block 1 so that another access is impossible
    static boolean dfs(int i, int j){
        if(i < 0 || i >= graph.length || j < 0 || j >= graph[0].length) return false;
        if(graph[i][j] == 1) return false; // if this cell was already visited

        graph[i][j] = 1;
        dfs(i-1, j);
        dfs(i+1, j);
        dfs(i, j-1);
        dfs(i, j+1);
        return true;
    }

    // for testing
    static void printGraph(){
        System.out.println("Printing current graph:");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}
