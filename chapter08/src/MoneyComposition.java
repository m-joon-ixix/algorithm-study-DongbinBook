/*
Problem 8-5 - Efficient Money Composition (p.226) - **Very Important**
-> When the units of money are not a multiple of each other (different from Greedy Algorithms)
*/

import java.util.Arrays;
import java.util.Scanner;

public class MoneyComposition {
    static int m; // amount of money to make
    static int[] currency; // unit of bills

    public static void main(String[] args){
        if(!getInput()) return;
        System.out.println("Result: " + solution());
    }

    static int solution(){
        int max = Integer.MAX_VALUE;
        int[] billsNeeded = new int[m + 1]; // billsNeeded[i]: minimum number of bills needed to make money of i
        // For each unit of bills, update the array billsNeeded
        billsNeeded[0] = 0;
        for(int i = 1; i <= m; i++) billsNeeded[i] = max; // initially, there is no way to make up any amount of money

        for(int k : currency){ // k: unit of money
            for(int i = k; i <= m; i++){ // update the billsNeeded[i]
                if(billsNeeded[i - k] != max){
                    billsNeeded[i] = Math.min(billsNeeded[i - k] + 1, billsNeeded[i]);
                } // else, we can't make $i using the unit k. So, keep the result made with past units of money
            }
        }

        if(billsNeeded[m] == max) return -1;
        else return billsNeeded[m];
    }

    static boolean getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert N, M: ");
        int n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        if(n < 1 || n > 100 || m < 1 || m > 10000){
            System.out.println("Invalid Input!");
            return false;
        }

        currency = new int[n];
        for(int i = 0; i < n; i++){
            currency[i] = scanner.nextInt();
            scanner.nextLine();
            if(currency[i] < 1 || currency[i] > 10000){
                System.out.println("Invalid Input!");
                return false;
            }
        }

        Arrays.sort(currency);
        return true;
    }
}
