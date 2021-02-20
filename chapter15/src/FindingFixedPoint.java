/*
Q.28 - Finding a Fixed Point (a point that the value is equal to its index) (p.368) - Amazon Interview
*/

import java.util.Arrays;
import java.util.Scanner;

public class FindingFixedPoint {
    static int n;
    static int[] array;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        System.out.println(binarySearch(0, n - 1));
    }

    // return the fixed point from array[start] to array[end], return -1 if it doesn't exist
    static int binarySearch(int start, int end){
        if(start > end) return -1;

        int mid = (start + end) / 2; // middle idx
        if(array[mid] < mid) return binarySearch(mid + 1, end);
        else if(array[mid] > mid) return binarySearch(start, mid - 1);
        else return mid;
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 1000000) return false;

        array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        sc.nextLine();

        Arrays.sort(array);
        return true;
    }
}
