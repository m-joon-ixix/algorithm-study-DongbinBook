/*
Problem 4-3 - Developing a Game (p.118)
*/

// Result comes out, but Runtime takes too long! What might be the reason...?

import java.util.Scanner;

public class GameInChapter4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type in N, M: ");
        int n = scanner.nextInt(), m = scanner.nextInt();

        System.out.print("Type in Initial position and Direction (0: N, 1: E, 2: S, 3: W): ");
        // a, b: current position of player // d: current direction of player
        int a = scanner.nextInt(), b = scanner.nextInt(), d = scanner.nextInt();

        System.out.println("Type in the " + n + " X " + m + " map (0 for ground, 1 for ocean): ");
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = false;
            }
        }
        visited[a][b] = true;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // {row_move, column_move}
        int nextA, nextB, turnedOnThisSpot = 0, count = 1;

        while(true){
            d--;
            if(d == -1) d = 3;
            turnedOnThisSpot++;

            nextA = a + directions[d][0];
            nextB = b + directions[d][1];
            if(map[nextA][nextB] == 0 && visited[nextA][nextB] == false){
                // moving forward
                a = nextA;
                b = nextB;
                visited[a][b] = true;
                count++;
                turnedOnThisSpot = 0;
            }

            if(turnedOnThisSpot == 4){
                nextA = a + directions[(d + 2) % 4][0];
                nextB = b + directions[(d + 2) % 4][1];
                if(map[nextA][nextB] == 1){
                    break;
                } else {
                    a = nextA;
                    b = nextB;
                }
            }
        }

        System.out.println("Total number of places visited: " + count);
    }
}
