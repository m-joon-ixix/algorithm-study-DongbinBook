/*
Problem 8-3 - Ant Warriors attacking others' food storage (p.220)
*/

import java.util.Scanner;

public class AntWarrior {
    static int[] foodCounts;

    public static void main(String[] args){
        if(!getInput()) return;
        System.out.println("Result: " + solution());
    }

    static int solution(){
        final int n = foodCounts.length;
        int[] arr = new int[n];
        arr[0] = foodCounts[0];
        arr[1] = Math.max(foodCounts[0], foodCounts[1]);
        for(int i = 2; i < n; i++){
            arr[i] = Math.max(arr[i-1], arr[i-2] + foodCounts[i]);
        }

        return arr[n - 1];
    }

    static boolean getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert N (3 <= N <= 100): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if(n < 3 || n > 100){
            System.out.println("Invalid Input!");
            return false;
        }

        foodCounts = new int[n];
        System.out.print("Insert " + n + " numbers for each storage's food count (0 ~ 1000): ");
        for(int i = 0; i < n; i++){
            foodCounts[i] = scanner.nextInt();
            if(foodCounts[i] < 0 || foodCounts[i] > 1000){
                System.out.println("Invalid Input!");
                return false;
            }
        }
        scanner.nextLine();

        return true;
    }
}
