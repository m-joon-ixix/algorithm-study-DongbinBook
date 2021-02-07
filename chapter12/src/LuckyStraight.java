/*
Q.07 - Lucky Straight (p.321)
*/

import java.util.Scanner;

public class LuckyStraight {
    static int N;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        if(isLucky(N)) System.out.println("LUCKY");
        else System.out.println("READY");
    }

    static boolean getInput(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        if(N < 10 || N > 99999999) return false;
        else return true;
    }

    static boolean isLucky(int n){
        int digits = numOfDigits(n);
        int[] numbers = new int[digits];
        for(int i = digits - 1; i >= 0; i--){
            numbers[i] = n % 10;
            n /= 10;
        }

        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < digits / 2; i++){
            sum1 += numbers[i];
        }
        for(int i = digits / 2; i < digits; i++){
            sum2 += numbers[i];
        }

        return sum1 == sum2;
    }

    static int numOfDigits(int n){
        int digits = 0;
        while(n > 0){
            n /= 10;
            digits++;
        }
        return digits;
    }
}
