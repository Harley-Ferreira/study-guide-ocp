package chapter_13_concurrency.p4_concurrent_collections;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) {
        // Using a HashMap instead ConcurrentHashMap we will obtain a ConcurrentModificationException
        // (This is not the best solution for removing, use Iterator.remove() or forEach() to avoid exceptions.)
        var foodData = new ConcurrentHashMap<String, Integer>();
        foodData.put("banana", 1);
        foodData.put("apple", 2);
        System.out.println(foodData);
        for (String key : foodData.keySet()) {
            foodData.remove(key);
        }
        System.out.println(foodData);

        List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4, 3, 42));
        for (var n : favNumbers) {
            favNumbers.add(n + 1);
        }
        System.out.println(favNumbers);
    }
}
