/*
Problem 6-3 - Printing students' grades in ascending order (p.180)
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class AscendingGrades {
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args){
        if(!getInput()) return;

        studentList = quickSort(studentList);

        System.out.print("Order of Students: ");
        for(Student student : studentList){
            System.out.print(student.name + " ");
        }
        System.out.println();
    }

    static boolean getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert number of students (1 <= N <= 100,000): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if(n < 1 || n > 100000){
            System.out.println("Invalid Input!");
            return false;
        }

        System.out.println("Insert " + n + " each student's name and score (Range of score is 1 to 100): ");
        String name, lineStr;
        int score;
        String[] line;
        for(int i = 0; i < n; i++){
            lineStr = scanner.nextLine();
            line = lineStr.split(" ");
            name = line[0];
            score = Integer.parseInt(line[1]);
            if(score < 1 || score > 100){
                System.out.println("Invalid Input!");
                return false;
            }
            studentList.add(new Student(name, score));
        }
        return true;
    }

    static List<Student> quickSort(List<Student> studentList){
        if(studentList.size() <= 1) return studentList;

        int pivotIdx = 0, leftIdx = 1, rightIdx = studentList.size() - 1;
        while(true){
            while(leftIdx < studentList.size() && studentList.get(pivotIdx).score >= studentList.get(leftIdx).score) leftIdx++;
            while(rightIdx > 0 && studentList.get(pivotIdx).score <= studentList.get(rightIdx).score) rightIdx--;
            if(leftIdx < rightIdx){
                Collections.swap(studentList, leftIdx, rightIdx);
            } else {
                break;
            }
        }

        Collections.swap(studentList, rightIdx, pivotIdx);
        pivotIdx = rightIdx; // pivotIdx changed to proper position

        List<Student> frontList = new ArrayList<>();
        List<Student> backList = new ArrayList<>();
        for(int i = 0; i < pivotIdx; i++){
            frontList.add(studentList.get(i));
        }
        for(int i = pivotIdx + 1; i < studentList.size(); i++){
            backList.add(studentList.get(i));
        }
        frontList = quickSort(frontList);
        backList = quickSort(backList);

        List<Student> resultList = new ArrayList<>();
        resultList.addAll(frontList);
        resultList.add(studentList.get(pivotIdx));
        resultList.addAll(backList);

        return resultList;
    }
}

class Student{
    String name;
    int score;

    Student(String name, int score){
        this.name = name;
        this.score = score;
    }
}