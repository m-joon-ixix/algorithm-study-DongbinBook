/*
Problem 8-2 - Making a Number into 1, with minimum calculation (p.217)
*/

import java.util.Scanner;

public class MakingOne {
    public static void main(String[] args){
        int x = getInput();
        if(x == -1) return;

        System.out.println("Result with my solution: " + mySolution(x));
        System.out.println("Result with solution with Dynamic Programming: " + solutionWithDP(x));
    }

    static int getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert X (1 <= X <= 30000): ");
        int x = scanner.nextInt();
        if(x < 1 || x > 30000){
            System.out.println("Invalid Input!");
            x = -1;
        }
        return x;
    }

    static int mySolution(int x){
        int count = 0, number = 1;
        while(number < x){
            if(number * 5 <= x) number *= 5;
            else if(number * 3 <= x) number *= 3;
            else if(number * 2 <= x) number *= 2;
            else number++;

            count++;
        }

        return count;
    }

    static int solutionWithDP(int x){
        int[] dpTable = new int[x + 1]; // dpTable[i]: number of operations need for making i to 1

        // Choose minimum of dpTable[i/5], dpTable[i/3], dpTable[i/2], dpTable[i-1]
        int aMinus, a2, a3, a5, min;
        for(int i = 2; i <= x; i++){
            aMinus = dpTable[i - 1];
            a2 = (i % 2 == 0) ? dpTable[i / 2] : Integer.MAX_VALUE;
            a3 = (i % 3 == 0) ? dpTable[i / 3] : Integer.MAX_VALUE;
            a5 = (i % 5 == 0) ? dpTable[i / 5] : Integer.MAX_VALUE;
            min = Math.min(aMinus, a2);
            min = Math.min(min, a3);
            min = Math.min(min, a5);
            dpTable[i] = 1 + min;
        }

        return dpTable[x];
    }
}
