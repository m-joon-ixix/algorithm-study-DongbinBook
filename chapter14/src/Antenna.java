/*
Q.24 - Antenna (p.360) - problem from Baekjoon Online Judge (18310)
*/

import java.util.Arrays;
import java.util.Scanner;

public class Antenna {
    static int[] houseLocations;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        int n = houseLocations.length;
        // the house in the middle among all houses should have the minimum total distance
        // if there are two middles, the left house
        int mid_idx = (n - 1) / 2;
        Arrays.sort(houseLocations);

        System.out.println(houseLocations[mid_idx]);

        // solutionLongTime();
    }

    // this solution is O(n^2) - computing total distances for every case of installing antennas
    static void solutionLongTime(){
        Arrays.sort(houseLocations);

        int[] distances = new int[houseLocations.length];
        for(int i = 0; i < houseLocations.length; i++){
            distances[i] = getTotalDistance(i);
        }

        int minIdx = 0; // find the idx of house with min. total distance
        for(int i = 1; i < distances.length; i++){
            if(distances[i] < distances[minIdx]) minIdx = i;
        }

        System.out.println(houseLocations[minIdx]);
    }

    static int getTotalDistance(int idx){
        // get the total distance to all houses if the antenna is installed in houseLocations[idx]
        int total = 0, thisHouseLocation = houseLocations[idx];
        for(int location : houseLocations){
            total += Math.abs(thisHouseLocation - location);
        }
        return total;
    }
    // ------------ upper part: not needed in real solution --------------

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 200000) return false;

        houseLocations = new int[n];
        for(int i = 0; i < n; i++){
            houseLocations[i] = sc.nextInt();
            if(houseLocations[i] > 100000) return false;
        }
        sc.nextLine();
        return true;
    }
}
