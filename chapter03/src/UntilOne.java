/*
Problem 3-4 - Until it becomes 1 (p.99)
*/

import java.util.Scanner;

public class UntilOne {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N, K (2 <= N, K <= 100000): ");
        int n = scanner.nextInt(), k = scanner.nextInt();
        if(n < 2 || n > 100000 || k < 2 || k > 100000){
            System.out.println("Invalid input!");
            return;
        }

        int count = 0;
        while(n > 1){
            if(n % k == 0) n /= k;
            else n -= 1;
            count++;
        }

        System.out.println("Result: " + count);
    }
}
