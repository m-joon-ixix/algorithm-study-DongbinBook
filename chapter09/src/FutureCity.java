/*
Problem 9-2: Future City (Floyd-Warshall Algorithm)
*/

import java.util.*;

public class FutureCity {
    static int x, k;
    static int[][] table; // table[i][j] >= 1 -> Can go from i to j

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        floydWarshall(table);

        if(table[1][k] >= 10000 || table[k][x] >= 10000) System.out.println(-1);
        else System.out.println(table[1][k] + table[k][x]);
    }

    static void floydWarshall(int[][] table){
        for(int k = 1; k < table.length; k++){
            // update the table considering paths crossing company k
            for(int i = 1; i < table.length; i++){
                for(int j = 1; j < table.length; j++){
                    // update table[i][j]
                    table[i][j] = Math.min(table[i][j], table[i][k] + table[k][j]);
                }
            }
        }
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 100 || m < 1 || m > 100) return false;
        table = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                table[i][j] = 10000; // not connected
            }
        }

        int a, b;
        for(int i = 0; i < m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            sc.nextLine();
            table[a][b] = 1;
            table[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        if(k < 1 || k > 100) return false;

        return true;
    }
}
