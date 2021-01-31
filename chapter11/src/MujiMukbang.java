// Chapter 11 - Q.06
// Problem from programmers.co.kr - 2019 Kakao Blind Recruitment

import java.util.*;

public class MujiMukbang {
    public static void main(String[] args){
        int[] food_times = {3, 7, 4};
        long k = 10L;
        System.out.println(solution(food_times, k));
    }

    static int solution(int[] food_times, long k) {
        PriorityQueue<Food> priorityQueue = new PriorityQueue<>();
        for(int time : food_times) priorityQueue.add(new Food(time));

        int prevMin, min = 0;
        long nextK = 0L;
        while(!priorityQueue.isEmpty()){
            prevMin = min;
            min = priorityQueue.peek().time;
            nextK = k - (long)(min - prevMin) * (long)priorityQueue.size();

            if(nextK >= 0){
                k = nextK;
                priorityQueue.poll();
            } else {
                break;
            }
        }

        if(nextK >= 0) return -1; // if there is no more food left

        List<Food> foodList = new ArrayList<>();
        for(Food food : priorityQueue) foodList.add(food);
        Collections.sort(foodList, new FoodSorterByNumber());

        return foodList.get((int)k % foodList.size()).number;
    }
}

class Food implements Comparable<Food>{
    static int numberOfFoods = 0;

    int number;
    int time;

    Food(int time){
        number = ++numberOfFoods;
        this.time = time;
    }

    @Override
    public int compareTo(Food otherFood){
        if(this.time > otherFood.time) return 1;
        else if(this.time == otherFood.time) return 0;
        else return -1;
    }

    // for Debugging
    @Override
    public String toString(){
        return "Food Number: " + this.number + "   Food_Time: " + this.time;
    }
}

class FoodSorterByNumber implements Comparator<Food>{
    @Override
    public int compare(Food food1, Food food2){
        if(food1.number > food2.number) return 1;
        else if(food1.number == food2.number) return 0;
        else return -1;
    }
}