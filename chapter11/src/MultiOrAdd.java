// Chapter 11 - Q.02

import java.util.Scanner;

public class MultiOrAdd {
    static int[] numbers;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }
        int result = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            result = Math.max(result + numbers[i], result * numbers[i]);
        }

        System.out.println(result);
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        numbers = new int[str.length()];
        char ch;
        for(int i = 0; i < str.length(); i++){
            ch = str.charAt(i);
            if(ch < '0' || ch > '9') return false;
            numbers[i] = ch - '0';
        }

        return true;
    }

}
