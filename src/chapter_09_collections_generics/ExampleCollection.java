package chapter_09_collections_generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/*
 *                    Collection
 *         /               |          \                 Map -> HashMap and TreeMap
 *       List            Queue          Set
 *     /      \       /    |           |     \
 *  ArrayList LinkedList   Deque    HashSet  TreeSet
 */
public class ExampleCollection {

    public static void main(String[] args) {
        Collection<String> fruitsArray = new ArrayList<>();
        Collection<String> fruitsSet = new HashSet<>();
        title("Adding Data");
        print(fruitsArray.add("Apple"));
        print(fruitsArray.add("Melon"));
        print(fruitsArray.add("Banana"));
        print(fruitsArray.add("Melon"));
        print(fruitsArray);

        print(fruitsSet.add("Apple"));
        print(fruitsSet.add("Melon"));
        print(fruitsSet.add("Banana"));
        print(fruitsSet.add("Melon"));
        print(fruitsSet);

        title("Removing Data");
        print(fruitsArray.remove("Melon"));
        print(fruitsArray);
        print(fruitsSet.remove("Apple"));
        print(fruitsSet);

        title("Counting Data");
        print(fruitsArray.isEmpty());
        print(fruitsArray.size());
        print(fruitsArray);
        print(fruitsSet.isEmpty());
        print(fruitsSet.size());
        print(fruitsSet);

        title("Check Contents");
        print(fruitsArray.contains("Apple"));
        print(fruitsSet.contains("Strawberry"));

        title("Iterating");
        fruitsArray.forEach(System.out::println);
        fruitsSet.forEach(System.out::println);

        title("Removing with Conditions");
        fruitsArray.removeIf(f -> f.equals("Pineapple"));
        fruitsSet.removeIf(f -> f.equals("Banana"));
        print(fruitsArray);
        print(fruitsSet);

        title("Determining Equality");
        System.out.println(fruitsArray.equals(fruitsSet));

        title("Clearing the Collection");
        fruitsArray.clear();
        fruitsSet.clear();
        print(fruitsArray);
        print(fruitsSet);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
