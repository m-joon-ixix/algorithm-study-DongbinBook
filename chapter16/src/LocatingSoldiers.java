/*
Q.34 - Deploying Soldiers (p.380) - Baekjoon Online Judge (#18353)
** Use LIS (Longest Increasing Subsequence) method. Should be decreasing (LDS) in this problem.
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class LocatingSoldiers {
    static int n;
    static int[] soldiers;
    static List<Integer>[] LDS; // LDS[i]: Longest Decreasing Subsequence that ends with soldier[i]

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        for(int i = 0; i < n; i++){
            LDS[i] = findLDS(i);
        }

        int maxLengthOfLDS = 0; // length of the longest decreasing subsequence
        for(int i = 0; i < n; i++){
            if(maxLengthOfLDS < LDS[i].size()) maxLengthOfLDS = LDS[i].size();
        }

        System.out.println(n - maxLengthOfLDS); // number of excluded soldiers
    }

    // find the LDS that ends with index 'end'
    static List<Integer> findLDS(int end){
        List<Integer> list = new ArrayList<>();
        if(end == 0){
            list.add(soldiers[0]);
            return list;
        }

        // need to put in soldiers[end]
        int idxOfLDStoConnect = -1;
        for(int i = 0; i < end; i++){
            // look at each LDS[i]
            boolean canAttach = LDS[i].get(LDS[i].size() - 1) > soldiers[end];
            if(canAttach){
                if(idxOfLDStoConnect == -1) idxOfLDStoConnect = i;
                else if(LDS[idxOfLDStoConnect].size() < LDS[i].size()) idxOfLDStoConnect = i;
            }
        }

        if(idxOfLDStoConnect != -1) for(int i : LDS[idxOfLDStoConnect]) list.add(i);
        list.add(soldiers[end]);

        return list;
    }

    static boolean getInput(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        if(n < 1 || n > 2000) return false;

        soldiers = new int[n];
        for(int i = 0; i < n; i++) soldiers[i] = sc.nextInt();
        sc.nextLine();

        LDS = new List[n];
        return true;
    }
}
