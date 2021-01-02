/*
Problem 4-1-2 - Time (p.113)
*/

import java.util.Scanner;

public class TimeProblem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N (0 <= N <= 23): ");
        int n = scanner.nextInt();

        Time time = new Time();
        int count = 0;
        while(!time.isFinished(n)){
            if(containsThree(time)) count++;
            time.increment();
        }

        System.out.println("Result: " + count);
    }

    static boolean containsThree(Time time){
        return containsThree(time.hour) || containsThree(time.minute) || containsThree(time.second);
    }

    static boolean containsThree(int number){
        return number / 10 == 3 || number % 10 == 3;
    }
}

class Time {
    int hour = 0;
    int minute = 0;
    int second = 0;

    void increment(){
        second++;
        if(second == 60){
            minute++;
            second = 0;
        }
        if(minute == 60){
            hour++;
            minute = 0;
        }
    }

    boolean isFinished(int n){
        return (hour == n + 1) && (minute == 0) && (second == 0);
    }
}
