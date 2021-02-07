/*
Q.10 - Locker and Key (p.325) - problem from programmers.co.kr
*/

public class LockerAndKey {
    public static void main(String[] args){
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    static boolean solution(int[][] key, int[][] lock) {
        int N = lock.length, M = key.length;
        int boardSize = N + 2*M;
        int[][] board;
        int[][] lockOnBoard = new int[boardSize][boardSize];
        // put the lock on board
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                lockOnBoard[i + M][j + M] = lock[i][j];
            }
        }

        // for each status, check if the key opens the lock
        for(int rotation = 0; rotation < 4; rotation++){
            // for each rotated key
            for(int i = 0; i <= M + N; i++){
                for(int j = 0; j < M + N; j++){
                    // top left position of key : (i, j)
                    board = matrixSum(lockOnBoard, putKeyOnBoard(key, i, j, boardSize));
                    if(keyFitsIn(board, N, M)) return true;
                }
            }
            key = rotateMatrix(key);
        }
        // if every case fails to open the lock, return false
        return false;
    }

    static int[][] matrixSum(int[][] matrix1, int[][] matrix2){
        // both matrices should be n x n
        int n = matrix1.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    static int[][] putKeyOnBoard(int[][] key, int i, int j, int boardSize){
        // top left position of key : (i, j)
        int[][] keyOnBoard = new int[boardSize][boardSize];
        for(int a = 0; a < key.length; a++){
            for(int b = 0; b < key.length; b++){
                keyOnBoard[a + i][b + j] = key[a][b];
            }
        }
        return keyOnBoard;
    }

    static boolean keyFitsIn(int[][] lockBoard, int N, int M){
        // lockBoard: key + bigLock added
        // if center NxN is all 1, lock is opened
        for(int i = M; i < M + N; i++){
            for(int j = M; j < M + N; j++){
                if(lockBoard[i][j] != 1) return false;
            }
        }
        return true;
    }

    static int[][] rotateMatrix(int[][] matrix){
        // rotates an (n x n) matrix clockwise 90 degrees
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for(int i = 0; i < n; i++){
            // column i becomes row i
            for(int j = 0; j < n; j++){
                // matrix[j][i] -> newMatrix[i][n-1-j] (j = 0, ..., n-1)
                newMatrix[i][n-1-j] = matrix[j][i];
            }
        }
        return newMatrix;
    }

    // for debugging
    static void printMatrix(int[][] matrix){
        System.out.println("Printing matrix:");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
