/*
Q.32 - Triangle with Integers (p.376) - 1994 IOI, Baekjoon Online Judge (#1932)
*/

import java.util.Scanner;

public class IntegerTriangle {
    static int n;
    static int[][] triangle; // triangle[i]: int[i + 1]
    static int[][] records;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }
        // input setup complete

        // records[i][j]: max sum if starting from triangle[i][j]
        records = new int[n][];
        for(int i = 0; i < n; i++){
            records[i] = new int[i + 1];
            for(int j = 0; j < records[i].length; j++){
                records[i][j] = -1; // not recorded status
            }
        }

        System.out.println(maxSumStartingFrom(0, 0));
    }

    static int maxSumStartingFrom(int i, int j){
        if(records[i][j] != -1) return records[i][j]; // if it was already computed before

        int recordThisTime;
        if(i == n - 1) recordThisTime = triangle[i][j];
        else recordThisTime = triangle[i][j] + Math.max(maxSumStartingFrom(i + 1, j), maxSumStartingFrom(i + 1, j + 1));

        records[i][j] = recordThisTime;
        return recordThisTime;
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 500) return false;

        triangle = new int[n][];
        for(int i = 0; i < n; i++){
            triangle[i] = new int[i + 1];
            for(int j = 0; j < i + 1; j++){
                triangle[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        return true;
    }
}
