/*
Q.31 - Gold mine (p.375) - Flipkart Interview
*/

import java.util.Scanner;

public class GoldMine {
    static int n, m;
    static int[][] goldMine;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // number of test cases
        sc.nextLine();

        for(int i = 0; i < T; i++){
            getInput();
            // use the goldMine map made in previous function to find the answer
            int maxGold = searchForMaxGold(0, 0);
            for(int row = 1; row < n; row++){
                maxGold = Math.max(maxGold, searchForMaxGold(row, 0));
            }
            System.out.println(maxGold);
        }
    }

    // returns the maximum number of gold mined, starting from cell (i, j) to the end of map (rightmost column)
    static int searchForMaxGold(int i, int j){
        if(i < 0 || i > n - 1) return -1; // if its not a proper call (row number i is out of range)
        if(j == m - 1) return goldMine[i][j]; // if its the rightmost cell

        int maxOfSearchesFromRight = Math.max(searchForMaxGold(i - 1, j + 1), searchForMaxGold(i, j + 1));
        maxOfSearchesFromRight = Math.max(maxOfSearchesFromRight, searchForMaxGold(i + 1, j + 1));

        return goldMine[i][j] + maxOfSearchesFromRight;
    }

    static void getInput(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        goldMine = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                goldMine[i][j] = sc.nextInt();
            }
        }
        sc.nextLine();
    }
}
