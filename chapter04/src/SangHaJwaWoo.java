/*
Problem 4-1-1 - Up Down Left Right (p.110)
*/

import java.util.Scanner;

public class SangHaJwaWoo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type in N (1 <= N <= 100): ");
        int n = scanner.nextInt();

        int row = 1, column = 1; // location of traveler

        System.out.print("Type in your moving plan: ");
        scanner.nextLine();

        String directions = scanner.nextLine();
        scanner = new Scanner(directions);
        char direction;
        while(scanner.hasNext()){
            direction = scanner.next().charAt(0);
            switch(direction){
                case 'U':
                    if(row != 1) row--;
                    break;
                case 'D':
                    if(row != n) row++;
                    break;
                case 'L':
                    if(column != 1) column--;
                    break;
                case 'R':
                    if(column != n) column++;
                    break;
                default:
                    System.out.println("Error: " + direction + " is not a proper key.");
            }
        }

        System.out.println("Result: " + row + " " + column);
    }
}
