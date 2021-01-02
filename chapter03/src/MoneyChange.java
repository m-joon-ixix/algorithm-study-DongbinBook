/*
Problem 3-1 - Changing Money (p.87)
*/

import java.util.Scanner;

public class MoneyChange {
    public static void main(String[] args){
        int[] coins = {500, 100, 50, 10};
        System.out.print("Insert the amount of change: ");
        Scanner scanner = new Scanner(System.in);
        int count = 0, n = scanner.nextInt();
        for(int coin : coins){
            count += (n / coin);
            n %= coin;
        }
        System.out.println("Number of coins needed: " + count);
    }
}
