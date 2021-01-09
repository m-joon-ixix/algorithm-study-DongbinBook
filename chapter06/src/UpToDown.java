/*
Problem 6-2 - Up to Down (p.178)
*/

import java.util.Scanner;

public class UpToDown {
    static int[] numbers;

    public static void main(String[] args){
        if(!getInput()) return;
        SortingAlgorithms.printArray(countSort(numbers));
    }

    static boolean getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert N (1 <= N <= 500): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if(n < 1 || n > 500){
            System.out.println("Invalid Input!");
            return false;
        }
        numbers = new int[n];
        System.out.println("Insert " + n + " numbers (Each number is an integer from 1 to 100,000): ");
        for(int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
            scanner.nextLine();
            if(numbers[i] < 1 || numbers[i] > 100000){
                System.out.println("Invalid Input!");
                return false;
            }
        }
        return true;
    }

    static int[] countSort(int[] array){
        int max = array[0], min = array[0];
        for(int i : array){
            if(max < i) max = i;
            if(min > i) min = i;
        }
        // actual number = idxOfArray + min
        int[] count = new int[max - min + 1];
        for(int number : array){
            count[number - min]++;
        }

        int currentIdx = array.length - 1;
        for(int i = 0; i < count.length; i++){
            for(int j = 0; j < count[i]; j++){
                array[currentIdx] = i + min;
                currentIdx--;
            }
        }

        return array;
    }

}
