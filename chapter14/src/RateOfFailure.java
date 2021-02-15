/*
Q.25 - Failure Rate for each Stage (p.361) - problem from programmers.co.kr (42889)
*/

import java.util.Arrays;

public class RateOfFailure {
    public static void main(String[] args){
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = solution2(N, stages);
        for(int i : result) System.out.print(i + " ");
        System.out.println();
    }

    // solution using the idea of Count Sort
    static int[] solution2(int N, int[] finalStages){
        int[] playersAtEachStage = new int[N+2];
        // playersAtEachStage[i]: number of players on stage i
        // count sort: counting number of players for each stage
        for(int i : finalStages) playersAtEachStage[i]++;

        Stage[] stages = new Stage[N + 1];
        for(int i = 0; i <= N; i++) stages[i] = new Stage(i); // stage number i

        int playersTried = finalStages.length; // number of players
        for(int i = 1; i <= N; i++){
            stages[i].tries = playersTried;
            stages[i].fails = playersAtEachStage[i];
            playersTried -= playersAtEachStage[i];
        }

        for(Stage stage : stages) stage.getFailRate();
        Arrays.sort(stages);

        int[] answer = new int[N];
        int answerIdx = 0;
        for(Stage stage : stages){
            if(stage.number != 0){
                answer[answerIdx] = stage.number;
                answerIdx++;
            }
        }
        return answer;
    }

    // solution with composite logic - just investigating tries and failures through given array
    static int[] solution1(int N, int[] finalStages) {
        // N: number of stages
        final int numOfPlayers = finalStages.length;

        Stage[] stages = new Stage[N]; // stages[i]
        for(int i = 0; i < N; i++) stages[i] = new Stage(i + 1);

        Arrays.sort(finalStages);
        // stages that every user passed
        if(finalStages[0] != N + 1){
            for(int i = 0; i < finalStages[0] - 1; i++){
                stages[i].tries = numOfPlayers;
                stages[i].fails = 0;
            }
        }

        int prev = 0, numOfPlayersAtThisStage = 1;
        for(int i = 0; i < finalStages.length; i++){
            if(finalStages[i] == N + 1){
                for(int j = prev + 1; j <= N; j++){
                    // from stage #(prev+1) to end, tries from users that passed all
                    stages[j - 1].tries = numOfPlayers - i;
                    stages[j - 1].fails = 0;
                }
                break;
            }

            if(prev == finalStages[i]){
                numOfPlayersAtThisStage++;
            } else {
                stages[finalStages[i] - 1].tries = numOfPlayers - i;
                if(prev != 0) stages[prev - 1].fails = numOfPlayersAtThisStage;
                numOfPlayersAtThisStage = 1;
            }
            prev = finalStages[i];
        }
        if(prev != 0) stages[prev - 1].fails = numOfPlayersAtThisStage;

        for(Stage stage : stages){
            stage.getFailRate();
            // stage.print();
        }

        Arrays.sort(stages);

        int[] answer = new int[N];
        for(int i = 0; i < N; i++) answer[i] = stages[i].number;
        return answer;
    }
}

class Stage implements Comparable<Stage>{
    int number;
    int fails;
    int tries;
    double failRate;

    Stage(int number){
        this.number = number;
        this.fails = 0;
        this.tries = 0;
        this.failRate = 0;
    }

    void getFailRate(){
        if(tries == 0) failRate = 0;
        else failRate = (double)fails / tries;
    }

    // for debugging
    void print(){
        System.out.println("Stage Number: " + number + "\t Fails, Tries: " + fails + ", " + tries + "\t Fail Rate: " + failRate);
    }

    @Override
    public int compareTo(Stage other){
        if(this.failRate < other.failRate) return 1;
        else if(this.failRate > other.failRate) return -1;
        else return Integer.compare(this.number, other.number);
    }
}
