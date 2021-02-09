/*
Problem 10-4: Going through a Curriculum - Topology Sort (p.303)
*/

import java.util.*;

public class Curriculum {
    static int n; // number of courses
    static Course[] courses; // courses[i]: course number i (1~n)
    static int[] inDegrees; // inDegree for each node(course)
    static List<Integer>[] graph; // adjacency graph. graph[i]

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        int[] minTimesToTake = new int[n + 1]; // time required to take each course
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            // courses that have no pre-course
            if(inDegrees[i] == 0) queue.add(i);
        }

        int courseNumber;
        while(!queue.isEmpty()){
            courseNumber = queue.poll(); // now, visited this course!
            // update the minTimesToTake table
            minTimesToTake[courseNumber] = Math.max(minTimesToTake[courseNumber], timeCalculator(courseNumber, minTimesToTake));
            for(int dest : graph[courseNumber]){
                inDegrees[dest]--; // get rid of this edge
                if(inDegrees[dest] == 0) queue.add(dest);
            }
        }

        // print the result
        for(int i = 1; i <= n; i++) System.out.println(minTimesToTake[i]);
    }

    static int timeCalculator(int courseNumber, int[] minTimesToTake){
        // calculates the minTime needed until we finish this course
        int timeNeededBeforeThisCourse = 0; // max time needed among the preCourses
        for(int preCourse : courses[courseNumber].preCourses){
            if(timeNeededBeforeThisCourse < minTimesToTake[preCourse]) timeNeededBeforeThisCourse = minTimesToTake[preCourse];
        }

        return timeNeededBeforeThisCourse + courses[courseNumber].timeToTake;
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 500) return false;

        courses = new Course[n + 1];
        inDegrees = new int[n + 1];
        graph = new List[n + 1];
        for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        int time, preCourse;
        for(int i = 1; i <= n; i++){
            time = sc.nextInt();
            courses[i] = new Course(time);
            while(true){
                preCourse = sc.nextInt();
                if(preCourse == -1) break;
                courses[i].preCourses.add(preCourse);
                inDegrees[i]++;
                graph[preCourse].add(i);
            }
            sc.nextLine();
        }

        return true;
    }
}

class Course{
    int timeToTake;
    List<Integer> preCourses = new ArrayList<>(); // list of pre-course numbers

    Course(int time){
        this.timeToTake = time;
    }
}
