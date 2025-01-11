package chapter_09_collections_generics.list;

import java.util.ArrayList;
import java.util.List;

/**
 * -List-
 * Use a list when you want an ordered collection that con contains duplicate entries
 *
 * -ArrayList-
 * When you aren't sure which collection to use, use an ArrayList.
 * Adding or removing an element is slower than accessing an element.
 * This make ArrayList a good choice when you are reading more often
 * than writing to the ArrayList.
 */
public class ExampleArrayList {

    public static void main(String[] args) {
        // Until Java version 4, there were no generics.
        // So, it was common to see codes like this:
        List collection = new ArrayList();
        collection.add("name");
        collection.add(1);
        collection.add(Boolean.TRUE);
        for (Object o : collection) {
            System.out.println(o);
        }
        // From Java 5 e 6 generics were implemented.
        List<String> list = new ArrayList<String>();
        list.add("name");
        list.add("1");
        list.add("Boolean.TRUE");
        for (String s : list) {
            System.out.println(s);
        }

        List<Integer> arrayOne = new ArrayList<Integer>();
        arrayOne.add(1);
        arrayOne.add(30);
        arrayOne.add(10);
        arrayOne.add(20);
        arrayOne.add(30);
        print(arrayOne);
        List<Integer> arrayTwo = new ArrayList<Integer>(arrayOne);
        print(arrayTwo);

        arrayOne.set(3, 55);
        arrayOne.sort((o1, o2) -> o1.compareTo(o2));
        arrayTwo.replaceAll(n -> n * 3);
        arrayTwo.sort(Integer::compareTo);
        print(arrayOne);
        print(arrayTwo);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
