// Chapter 11 - Q.03

import java.util.Scanner;

public class ReverseString {
    static boolean[] digits; // 1 for true, 0 for false

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        boolean goal = digits[0], inAction = false;
        int count = 0; // total number of reverse actions
        for(int i = 1; i < digits.length; i++){
            if(!inAction && digits[i] != goal){
                count++;
                inAction = true;
            }
            if(inAction && digits[i] == goal){
                inAction = false;
            }
        }

        System.out.println(count);
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        digits = new boolean[str.length()];
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1') digits[i] = true;
            else if(str.charAt(i) == '0') digits[i] = false;
            else return false;
        }

        return true;
    }
}
