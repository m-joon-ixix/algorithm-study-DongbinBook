/*
Q.23 - Korean, English, Math (p.359) - problem from Baekjoon Online Judge (10825)
*/

import java.util.Arrays;
import java.util.Scanner;

public class KorEngMath {
    static Student[] studentArray;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        Arrays.sort(studentArray);
        for(Student student : studentArray) System.out.println(student.name);
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 100000) return false;

        studentArray = new Student[n];
        String studentInfo;
        String[] studentInfoSplit;
        for(int i = 0; i < n; i++){
            studentInfo = sc.nextLine();
            studentInfoSplit = studentInfo.split(" ");
            studentArray[i] = new Student(studentInfoSplit[0],
                    Integer.parseInt(studentInfoSplit[1]), Integer.parseInt(studentInfoSplit[2]), Integer.parseInt(studentInfoSplit[3]));
        }

        return true;
    }
}

class Student implements Comparable<Student>{
    String name;
    int korean;
    int english;
    int math;

    Student(String name, int kor, int eng, int math){
        this.name = name;
        this.korean = kor;
        this.english = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student other){
        if(this.korean < other.korean) return 1;
        else if(this.korean > other.korean) return -1;
        else {
            if(this.english > other.english) return 1;
            else if(this.english < other.english) return -1;
            else {
                if(this.math < other.math) return 1;
                else if(this.math > other.math) return -1;
                else return this.name.compareTo(other.name);
            }
        }
    }
}
