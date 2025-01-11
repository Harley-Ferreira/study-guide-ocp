package chapter_09_collections_generics.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class ExampleComparable implements Comparable<ExampleComparable>{
    private String name;

    public ExampleComparable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(ExampleComparable o) {
        return name.compareTo(o.name);
    }

    public static void main(String[] args) {
        title("COMPARABLE");
        var foods = new ArrayList<ExampleComparable>();
        foods.add(new ExampleComparable("Pasta"));
        foods.add(new ExampleComparable("Roast Meat"));
        foods.add(new ExampleComparable("Salad"));
        foods.add(new ExampleComparable("Rice"));
        foods.add(new ExampleComparable("Burger"));
        foods.add(new ExampleComparable("Barbecue"));
        foods.add(new ExampleComparable("Eggs"));
        print(foods);
        Collections.sort(foods);
        print("Sorted: " + foods);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
