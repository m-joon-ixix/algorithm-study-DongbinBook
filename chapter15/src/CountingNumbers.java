/*
Q.27 - Counting the number of a particular element in a sorted array (p.367) - Zoho Interview
*/

import java.util.Arrays;
import java.util.Scanner;

public class CountingNumbers {
    static int N, x;
    static int[] array;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }
        // array is sorted already
        int idxOfX = binarySearch(0, N - 1, x);
        if(idxOfX == -1){
            System.out.println(-1);
            return;
        }

        int xInLeft = 0, xInRight = 0; // number of x's in the left and right of idxOfX
        for(int i = idxOfX - 1; i >= 0; i--){
            if(array[i] == x) xInLeft++;
            else break;
        }
        for(int i = idxOfX + 1; i < N; i++){
            if(array[i] == x) xInRight++;
            else break;
        }

        System.out.println(xInLeft + xInRight + 1);
    }

    static int binarySearch(int start, int end, int target){
        if(start > end) return -1;

        int mid = (start + end) / 2;
        if(target < array[mid]) return binarySearch(start, mid - 1, target);
        else if(target > array[mid]) return binarySearch(mid + 1, end, target);
        else return mid;
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        x = sc.nextInt();
        sc.nextLine();
        if(N < 1 || N > 1000000) return false;

        array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        sc.nextLine();

        Arrays.sort(array);
        return true;
    }
}
