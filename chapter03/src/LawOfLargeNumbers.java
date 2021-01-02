/*
Problem 3-2 - Dongbin's Law of Large Numbers (p.92)
*/

import java.util.Arrays;
import java.util.Scanner;

public class LawOfLargeNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n, m, k;
        System.out.print("Type in N, M, K separated with empty spaces: ");
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        if(n < 2 || n > 1000 || m < 1 || m > 10000 || k < 1 || k > 10000 || k > m){
            System.out.println("Invalid input!");
            return;
        }

        System.out.print("Type in " + n + " integers, separated with empty spaces: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
            if(arr[i] < 1 || arr[i] > 10000){
                System.out.println("Invalid input!");
                return;
            }
        }

        Arrays.sort(arr);
        int first = arr[n-1], second = arr[n-2];

        int repeat = 0, sum = 0;
        for(int i = 0; i < m; i++){
            if(repeat == k){
                sum += second;
                repeat = 0;
                continue;
            }

            sum += first;
            repeat++;
        }

        System.out.println("Result: " + sum);
    }
}
