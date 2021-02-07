/*
Q.18 - Changing the string of brackets (p.346) - problem from programmers.co.kr (60058)
*/

import java.util.Stack;

public class BracketChange {
    public static void main(String[] args){
        String str = "()))((()";
        System.out.println(solution(str));
    }

    static String solution(String p) {
        if(p.isEmpty()) return "";
        if(isCorrectString(p)) return p;

        String u, v;
        int idx = 1; // u is going to be p.subString(0, idx+1)
        while(true){
            if(isBalancedString(p.substring(0, idx + 1))){
                u = p.substring(0, idx + 1);
                break;
            }
            idx++;
        }
        if(idx == p.length() - 1) v = "";
        else v = p.substring(idx + 1);

        if(isCorrectString(u)){
            return u + solution(v);
        } else {
            String answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1);
            String uReversed = "";
            for(int i = 0; i < u.length(); i++){
                if(u.charAt(i) == '(') uReversed += ")";
                else uReversed += "(";
            }
            answer += uReversed;
            return answer;
        }
    }

    static boolean isBalancedString(String str){
        int leftBrackets = 0, rightBrackets = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(') leftBrackets++;
            if(str.charAt(i) == ')') rightBrackets++;
        }
        return leftBrackets == rightBrackets;
    }

    static boolean isCorrectString(String str){
        Stack<Character> stack = new Stack<>(); // stack for having '('
        char ch;
        for(int i = 0; i < str.length(); i++){
            ch = str.charAt(i);
            if(ch == '('){
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return true;
    }
}
