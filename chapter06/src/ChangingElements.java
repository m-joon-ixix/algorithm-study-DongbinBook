/*
Problem 6-4 - Changing two arrays' elements (p.182)
*/

import java.util.Scanner;

public class ChangingElements {
    static int[] a;
    static int[] b;
    static int k;

    public static void main(String[] args) {
        if(!getInput()) return;

        int temp;
        while(k > 0 && a[getMinIdx(a)] < b[getMaxIdx(b)]){
            temp = a[getMinIdx(a)];
            a[getMinIdx(a)] = b[getMaxIdx(b)];
            b[getMaxIdx(b)] = temp;
            k--;
        }

        int result = 0;
        for(int i : a){
            result += i;
        }
        System.out.println("Final Result: " + result);
    }

    static boolean getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert N, K (1 <= N <= 100000, 0 <= K <= N): ");
        int n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        if (n < 1 || n > 100000 || k < 0 || k > n) {
            System.out.println("Invalid Input!");
            return false;
        }
        a = new int[n];
        b = new int[n];
        System.out.println("Insert " + n + " numbers for each array A and B: ");
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
            if(a[i] <= 0 || a[i] >= 10000000){
                System.out.println("Invalid Input!");
                return false;
            }
        }
        scanner.nextLine();
        for(int i = 0; i < n; i++){
            b[i] = scanner.nextInt();
            if(b[i] <= 0 || b[i] >= 10000000){
                System.out.println("Invalid Input!");
                return false;
            }
        }
        scanner.nextLine();

        return true;
    }

    static int getMaxIdx(int[] array){
        int maxIdx = 0;
        for(int i = 1; i < array.length; i++){
            if(array[i] > array[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }

    static int getMinIdx(int[] array){
        int minIdx = 0;
        for(int i = 1; i < array.length; i++){
            if(array[i] < array[minIdx]) minIdx = i;
        }
        return minIdx;
    }
}
