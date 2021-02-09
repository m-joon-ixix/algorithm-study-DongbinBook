/*
Problem 10-2: Making Teams - Disjoint Set Union Algorithm (p.298)
*/

import java.util.Scanner;

public class MakingTeams {
    static int n;
    static Operation[] operations;

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        int[] parentTable = new int[n + 1];
        for(int i = 0; i <= n; i++) parentTable[i] = i;

        for(Operation operation : operations){
            if(operation.type == 0){
                unionParent(parentTable, operation.a, operation.b);
            } else if(operation.type == 1){
                if(sameTeam(parentTable, operation.a, operation.b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    static int findParent(int[] parentTable, int x){
        // find the root node of node x
        if(parentTable[x] != x) parentTable[x] = findParent(parentTable, parentTable[x]);
        return parentTable[x];
    }

    static void unionParent(int[] parentTable, int a, int b){
        int rootOfA = findParent(parentTable, a);
        int rootOfB = findParent(parentTable, b);
        if(rootOfA < rootOfB) parentTable[rootOfB] = rootOfA;
        else parentTable[rootOfA] = rootOfB;
    }

    static boolean sameTeam(int[] parentTable, int a, int b){
        return findParent(parentTable, a) == findParent(parentTable, b);
    }

    static boolean getInput(){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        if(n < 1 || n > 100000 || m < 1 || m > 100000) return false;

        operations = new Operation[m];
        int type, a, b;
        for(int i = 0; i < m; i++){
            type = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            if((type != 0 && type != 1) || a > n || b > n) return false;
            operations[i] = new Operation(type, a, b);
            scanner.nextLine();
        }

        return true;
    }
}

class Operation{
    int type; // 0 for union, 1 for sameTeam
    int a;
    int b;

    Operation(int type, int a, int b){
        this.type = type;
        this.a = a;
        this.b = b;
    }
}
