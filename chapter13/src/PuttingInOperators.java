/*
Q.19 - Putting in Operators between numbers - problem from Baekjoon Online Judge (14888)
*/

import java.util.Scanner;

public class PuttingInOperators {
    static int[] numbers;
    static int add, sub, mul, div, N;
    static int min, max;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        putOperator(1, numbers[0], add, sub, mul, div);

        System.out.println(max);
        System.out.println(min);
    }

    // when putting an operator after (i)th number. Calculation until (i)th number was 'value'
    static void putOperator(int i, int value, int add_left, int sub_left, int mul_left, int div_left){
        if(i == N){
            // calculation should end with 'value'. update min, max
            if(min > value) min = value;
            if(max < value) max = value;
            return;
        }

        if(add_left > 0) putOperator(i + 1, value + numbers[i], add_left - 1, sub_left, mul_left, div_left);
        if(sub_left > 0) putOperator(i + 1, value - numbers[i], add_left, sub_left - 1, mul_left, div_left);
        if(mul_left > 0) putOperator(i + 1, value * numbers[i], add_left, sub_left, mul_left - 1, div_left);
        if(div_left > 0) putOperator(i + 1, value / numbers[i], add_left, sub_left, mul_left, div_left - 1);
    }

    static boolean getInput(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        if(N < 2 || N > 11) return false;
        numbers = new int[N];
        for(int i = 0; i < N; i++){
            numbers[i] = scanner.nextInt();
        }
        scanner.nextLine();

        add = scanner.nextInt();
        sub = scanner.nextInt();
        mul = scanner.nextInt();
        div = scanner.nextInt();
        scanner.nextLine();
        if(add + sub + mul + div != N - 1) return false;

        return true;
    }
}
