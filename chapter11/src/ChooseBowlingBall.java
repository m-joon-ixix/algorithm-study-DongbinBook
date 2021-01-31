// Chapter 11 - Q.05

import java.util.Scanner;

public class ChooseBowlingBall {
    static int[] weights;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        int count = 0;
        for(int i = 0; i < weights.length - 1; i++){
            for(int j = i + 1; j < weights.length; j++){
                if(weights[i] != weights[j]) count++;
            }
        }

        System.out.println(count);
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 1000 || m < 1 || m > 10) return false;

        weights = new int[n];
        for(int i = 0; i < n; i++){
            weights[i] = sc.nextInt();
            if(weights[i] < 1 || weights[i] > m) return false;
        }
        sc.nextLine();

        return true;
    }
}
