package chapter_09_collections_generics.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * OBS: In my opinion using Comparator is better than Comparable
 * because we can use methods reference, so we can write less code.
 *
 * Comparator can be implemented too
 */
public class ExampleComparator {

    private String name;

    public ExampleComparator(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        title("COMPARATOR");
        var foods = new ArrayList<ExampleComparator>();
        foods.add(new ExampleComparator("Pasta"));
        foods.add(new ExampleComparator("Roast Meat"));
        foods.add(new ExampleComparator("Salad"));
        foods.add(new ExampleComparator("Rice"));
        foods.add(new ExampleComparator("Burger"));
        foods.add(new ExampleComparator("Barbecue"));
        foods.add(new ExampleComparator("Eggs"));
        print(foods);
        Comparator<ExampleComparator> byName = new Comparator<ExampleComparator>() {
            @Override
            public int compare(ExampleComparator o1, ExampleComparator o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        // or with lambda
        // Comparator<ExampleComparator> byName = (o1, o2) -> o1.name.compareTo(o2.name);
        // or with methods reference
        // Comparator<ExampleComparator> byName = Comparator.comparing(o -> o.name);
        Collections.sort(foods, byName);
        print("Sorted: " + foods);

        var list = Arrays.asList(5, 4, 7, 2);

        Comparator<Integer> c1 = (o1, o2) -> o2 - o1;
        Comparator<Integer> c2 = Comparator.naturalOrder();
        Comparator<Integer> c3 = Comparator.reverseOrder();
        Collections.sort(list, c1);
        print(list); // [7, 5, 4, 2]
        Collections.reverse(list);
        print(list); // [2, 4, 5, 7]
        Collections.reverse(list);
        print(list); // [7, 5, 4, 2]
        print(Collections.binarySearch(list, 2)); // -1  (last index)
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
