/*
Problem 7-3 - Making rice-cake for tteokbokki (p.201)
*/

import java.util.Scanner;

public class Tteokbokki {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert N, M (1 <= N <= 1000000, 1 <= M <= 2000000000): ");
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();
        if(n < 1 || n > 1000000 || m < 1 || m > 2000000000){
            FindingParts.invalidInput();
            return;
        }
        System.out.print("Type in " + n + " heights: ");
        int[] heights = new int[n];
        for(int i = 0; i < n; i++){
            heights[i] = scanner.nextInt();
            if(heights[i] < 0){
                FindingParts.invalidInput();
                return;
            }
        }
        scanner.nextLine();

        // answer is gonna be in this range (start ~ end)
        int start = 0, end = maxOfArray(heights);
        int mid, cut;
        while(true){
            mid = (start + end) / 2;
            if(start == end) break;
            if(end - start == 1) mid = end;

            cut = amountThatWasCut(heights, mid);
            if(cut > m) start = mid;
            else if(cut < m) end = mid - 1;
            else break;
        }

        System.out.println("Result: " + mid);
    }

    static int maxOfArray(int[] array){
        int max = array[0];
        for(int number : array){
            if(max < number) max = number;
        }
        return max;
    }

    static int amountThatWasCut(int[] heights, int cutHeight){
        int amount = 0;
        for(int height : heights){
            if(height > cutHeight) amount += (height - cutHeight);
        }
        return amount;
    }
}
