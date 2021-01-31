// Chapter 11 - Q.01

import java.util.Scanner;

public class TravelerGuild {
    static int[] levels;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }
        selectionSort(levels);

        int groups = 0, members = 0;
        for(int level : levels){
            members++;
            if(level <= members){
                groups++;
                members = 0;
            }
        }

        System.out.println(groups);
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 100000) return false;
        levels = new int[n];
        for(int i = 0; i < n; i++){
            levels[i] = sc.nextInt();
            if(levels[i] < 1 || levels[i] > n) return false;
        }
        sc.nextLine();
        return true;
    }

    static void selectionSort(int[] array){
        // sort into ascending order
        int minIdx, temp;
        for(int i = 0; i < array.length - 1; i++){
            minIdx = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIdx]) minIdx = j;
            }
            temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }
    }
}
