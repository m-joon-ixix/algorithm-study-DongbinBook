// Chapter 11 - Q.04

import java.util.Scanner;

public class NumbersUnableToMake {
    static int[] coins;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }
        TravelerGuild.selectionSort(coins);

        int moneyMade = 0, result = 1;
        for(int coin : coins){
            // (0 ~ moneyMade) can be made using previous coins -> by adding 'coin', we can make coin ~ (moneyMade + coin)
            // if there is something empty between moneyMade and coin, we can't make that amount of money
            if(coin <= moneyMade + 1){
                moneyMade = moneyMade + coin;
            } else {
                result = moneyMade + 1;
                break;
            }
        }

        System.out.println(result);
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 1000) return false;
        coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
            if(coins[i] < 1 || coins[i] > 1000000) return false;
        }

        return true;
    }
}
