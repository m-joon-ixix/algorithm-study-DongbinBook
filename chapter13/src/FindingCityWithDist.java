/*
Q.15 - Finding Cities with Particular Distance (p.339) - problem from Baekjoon Online Judge (18352)
*/

import java.util.*;

public class FindingCityWithDist {
    static int[] minDistances;
    static int n, x, k;
    static List<Integer>[] graph; // graph[i]: list with destinations available from city i

    public static void main(String[] args){
        if(!getInput()){
            System.out.println("Invalid Input!");
            return;
        }

        BFS(x);

        boolean exists = false; // does a city with distance k exist?
        for(int city = 1; city <= n; city++){
            if(minDistances[city] == k){
                exists = true;
                System.out.println(city);
            }
        }
        if(!exists) System.out.println(-1);
    }

    static boolean getInput(){
        Scanner scanner = new Scanner(System.in);
        int m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        x = scanner.nextInt();
        scanner.nextLine();

        if(n < 2 || x > n) return false;

        minDistances = new int[n + 1];
        for(int i = 1; i <= n; i++) minDistances[i] = Integer.MAX_VALUE;
        graph = new List[n + 1];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        int from, to;
        for(int i = 0; i < m; i++){
            from = scanner.nextInt();
            to = scanner.nextInt();
            scanner.nextLine();
            if(from > n || to > n) return false;
            graph[from].add(to);
        }

        return true;
    }

    // fill up 'minDistances'
    static void BFS(int start){
        minDistances[start] = 0;

        Queue<City> queue = new LinkedList<>();
        queue.add(new City(start, 0));
        City currentCity;
        int newDist;
        while(!queue.isEmpty()){
            currentCity = queue.poll();
            newDist = currentCity.distance + 1;
            for(int dest : graph[currentCity.number]){
                if(minDistances[dest] > newDist){
                    minDistances[dest] = newDist;
                    queue.add(new City(dest, newDist));
                }
            }
        }
    }
}

class City{
    int number;
    int distance;

    City(int number, int distance){
        this.number = number;
        this.distance = distance;
    }
}
