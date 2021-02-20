/*
Q.32 - Triangle with Integers (p.376) - 1994 IOI, Baekjoon Online Judge (#1932)
*/

import java.util.Scanner;

public class IntegerTriangle {
    static int n;
    static int[][] triangle; // triangle[i]: int[i + 1]

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }
        // input setup complete

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
