/*
Problem 7-2 - Finding Parts (p.197)
*/

import java.util.Arrays;
import java.util.Scanner;

public class FindingParts {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert N (1 <= N <= 1,000,000): ");
        int n = scanner.nextInt(); scanner.nextLine();
        if(n < 1 || n > 1000000){
            invalidInput();
            return;
        }
        int[] parts = new int[n];
        System.out.print("Type in " + n + " part numbers (1 < part # <= 1,000,000): ");
        for(int i = 0; i < n; i++){
            parts[i] = scanner.nextInt();
            if(parts[i] <= 1 || parts[i] > 1000000){
                invalidInput();
                return;
            }
        }
        scanner.nextLine();

        System.out.print("Insert M (1 <= M <= 100,000): ");
        int m = scanner.nextInt(); scanner.nextLine();
        if(m < 1 || m > 100000){
            invalidInput();
            return;
        }
        int[] requests = new int[m];
        System.out.print("Type in " + m + " part numbers you are looking for (1 < part # <= 1,000,000): ");
        for(int i = 0; i < m; i++){
            requests[i] = scanner.nextInt();
            if(requests[i] <= 1 || requests[i] > 1000000){
                invalidInput();
                return;
            }
        }
        scanner.nextLine();

        System.out.println();
        Arrays.sort(parts);
        System.out.print("Result: ");
        for(int request : requests){
            if(binarySearch(parts, request, 0, parts.length - 1)) System.out.print("yes");
            else System.out.print("no");
            System.out.print(" ");
        }
    }

    static boolean binarySearch(int[] array, int target, int start, int end){ // array should be sorted in advance
        if(start > end) return false;

        int mid = (start + end) / 2;
        if(array[mid] == target) return true;
        else if(array[mid] > target) return binarySearch(array, target, start, mid - 1);
        else return binarySearch(array, target, mid + 1, end);
    }

    static void invalidInput(){
        System.out.println("Invalid Input!");
    }
}
