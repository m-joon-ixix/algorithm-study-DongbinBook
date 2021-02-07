/*
Q.09 - String Compression (p.323) - problem from programmers.co.kr
*/

import java.util.Scanner;

public class StringCompression {
    static String str;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        System.out.println(solution(str));
    }

    static boolean getInput(){
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        if(str.length() > 1000) return false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) < 'a' || str.charAt(i) > 'z') return false;
        }
        return true;
    }

    static int solution(String s) {
        if(s.length() == 1) return 1;

        // minLengths[i]: minLength when string is partitioned to block size i
        int[] minLengths = new int[s.length() / 2 + 1]; // don't use [0]
        int length, idx; // length: minLength possible, idx: starting point of each substring
        boolean repeating; // whether a substring is being repeated
        int repeatCount; // number of times that the substring was repeated
        String prev, curr; // substrings
        for(int size = 1; size <= s.length() / 2; size++){
            prev = "";
            curr = "";
            length = 0;
            idx = 0;
            repeating = false;
            repeatCount = 1;

            while(idx + size <= s.length()){
                prev = curr;
                curr = s.substring(idx, idx + size);
                if(!repeating && prev.equals(curr)){
                    repeating = true;
                    repeatCount = 2;
                } else if(repeating && !prev.equals(curr)){
                    repeating = false;
                    length += numOfDigits(repeatCount);
                    repeatCount = 1;
                    length += size;
                } else if(!repeating && !prev.equals(curr)){
                    length += size;
                } else { // when repeating && prev.equals(curr)
                    repeatCount++;
                }

                // increment the starting point of substring
                idx += size;
            }

            if(repeating) length += numOfDigits(repeatCount); // add the number of times last substring was repeated

            length += (s.length() - idx); // for the remaining letters at the end of string
            minLengths[size] = length; // save this result
        }

        int min = minLengths[1];
        for(int i = 2; i < minLengths.length; i++){
            if(minLengths[i] < min) min = minLengths[i];
        }
        return min;
    }

    static int numOfDigits(int n){
        int digits = 0;
        while(n > 0){
            n /= 10;
            digits++;
        }
        return digits;
    }
}
