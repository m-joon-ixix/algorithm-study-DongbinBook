/*
Problem 5-4 : Escaping a Maze (p.152)
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class MazeEscape {
    // map: (1, 1) ~ (N, M) = entrance ~ exit
    // monster exists: 0, accessible: 1
    static int[][] map;

    public static void main(String[] args){
        getMapInfo();
        System.out.println("Final Result: " + bfs(0, 0));
    }

    static void getMapInfo(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();
        if(n < 4 || n > 200 || m < 4 || m > 200){
            System.out.println("Invalid Input!");
            return;
        }
        map = new int[n][m];
        String lineStr;
        for(int i = 0; i < n; i++){
            lineStr = scanner.nextLine();
            for(int j = 0; j < m; j++){
                map[i][j] = lineStr.charAt(j) - '0';
            }
        }
    }

    static int bfs(int i, int j){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        int nextRow, nextCol;
        Point point;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            point = queue.poll();
            for(int k = 0; k < 4; k++){
                nextRow = point.row + dRow[k];
                nextCol = point.column + dCol[k];
                // if out of index
                if(nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) continue;
                // if visited for the first time
                if(map[nextRow][nextCol] == 1){
                    map[nextRow][nextCol] = map[point.row][point.column] + 1;
                    queue.add(new Point(nextRow, nextCol));
                }
            }
        }

        return map[map.length - 1][map[0].length - 1];
    }
}

class Point{
    int row;
    int column;
    Point(int row, int column){
        this.row = row;
        this.column = column;
    }
}