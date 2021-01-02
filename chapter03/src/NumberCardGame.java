/*
Problem 3-3 - Number Card Game (p.96)
*/

import java.util.Arrays;
import java.util.Scanner;

public class NumberCardGame {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N, M (1 <= N, M <= 100): ");
        int n = scanner.nextInt(), m = scanner.nextInt();
        if(n < 1 || n > 100 || m < 1 || m > 100){
            System.out.println("Invalid input!");
            return;
        }

        int[][] cards = new int[n][m];
        System.out.println("Enter the " + n + " X " + m + " card table:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cards[i][j] = scanner.nextInt();
                if(cards[i][j] < 1 || cards[i][j] > 10000){
                    System.out.println("Invalid input!");
                    return;
                }
            }
        }

        int[] minNumbersPerRow = new int[n];
        int min;
        for(int i = 0; i < n; i++){
            min = cards[i][0];
            for(int j = 1; j < m; j++){
                if(cards[i][j] < min) min = cards[i][j];
            }
            minNumbersPerRow[i] = min;
        }

        Arrays.sort(minNumbersPerRow);
        System.out.println("Result: " + minNumbersPerRow[n-1]);
    }
}
