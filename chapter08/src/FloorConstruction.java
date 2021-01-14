/*
Problem 8-4 - Filling in a floor with size N X 2, using three types of tiles (1 X 2, 2 X 1, 2 X 2) (p.223)
*/

import java.util.Scanner;

public class FloorConstruction {
    public static void main(String[] args){
        int n = getInput();
        if(n == -1) return;
        System.out.println("Result using Dynamic Programming: " + solutionWithDP(n));
    }

    static int getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert N (1 <= N <= 1000): ");
        int n = scanner.nextInt();
        if(n < 1 || n > 1000){
            System.out.println("Invalid Input!");
            n = -1;
        }
        return n;
    }

    static int solutionWithDP(int n){
        // dpTable[i]: number of ways to fill in a 'i X 2 floor'
        int[] dpTable = new int[n + 1];
        dpTable[1] = 1;
        dpTable[2] = 3;
        for(int i = 3; i <= n; i++){
            dpTable[i] = 2 * dpTable[i - 2] + dpTable[i - 1];
        }

        return dpTable[n];
    }
}
