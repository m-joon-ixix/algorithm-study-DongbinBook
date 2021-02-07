/*
Q.08 - String Reorganization (p.322)
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringReorganizing {
    static String str;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        char ch;
        List<Character> charList = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z') charList.add(ch);
        }
        Collections.sort(charList);
        for(char c : charList) System.out.print(c);

        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') sum += (ch - '0');
        }
        System.out.println(sum);
    }

    static boolean getInput(){
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        if(str.length() > 10000) return false;
        for(int i = 0; i < str.length(); i++){
            if(!isProperChar(str.charAt(i))) return false;
        }
        return true;
    }

    static boolean isProperChar(char c){
        if(c >= 'A' && c <= 'Z') return true;
        else if(c >= '0' && c <= '9') return true;
        else return false;
    }
}
