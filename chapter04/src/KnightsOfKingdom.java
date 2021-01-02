/*
Problem 4-2 -  Knights of the Kingdom (p.115)
*/

import java.util.Scanner;

public class KnightsOfKingdom {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type in the location of knight: ");
        String location = scanner.nextLine();
        int column = location.charAt(0) + 1 - 'a';
        int row = location.charAt(1) - '0';

        if(row < 1 || row > 8 || column < 1 || column > 8){
            System.out.println("Invalid input!");
            return;
        }

        int result = 0;
        if(row >= 3){
            if(column >= 2) result++;
            if(column <= 7) result++;
        }
        if(row <= 6){
            if(column >= 2) result++;
            if(column <= 7) result++;
        }
        if(column >= 3){
            if(row >= 2) result++;
            if(row <= 7) result++;
        }
        if(column <= 6){
            if(row >= 2) result++;
            if(row <= 7) result++;
        }

        System.out.println("Number of ways to move: " + result);
    }
}
