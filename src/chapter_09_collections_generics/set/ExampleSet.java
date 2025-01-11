package chapter_09_collections_generics.set;

import java.util.HashSet;
import java.util.Set;

/**
 * -Set-
 * Use a Set when you don't want to allow duplicate entries.
 * The main benefits that adding elements and checking whether
 * an element is in the set both have. The trade-off is that you
 * lose the order in which you inserted the elements.
 */
public class ExampleSet {

    public static void main(String[] args) {
        title("------- Working with Set Methods ---------");
        // Set<Character> letters = Set.of('z', 'o', 'a', 'o'); DON'T COMPILE
        Set<Character> letters = Set.of('z', 'o', 'a');
        Set<Character> copy = Set.copyOf(letters);
        print(letters); // z, o, a, b
        print(copy); // z, o, a, b
        // methods of and copyOf create imutable Set, so it's not possible to use add method

        Set<String> fruitsSet = new HashSet<>();
        title("Adding Data");
        print(fruitsSet.add("Apple")); // true
        print(fruitsSet.add("Melon")); // true
        print(fruitsSet.add("Banana")); // true
        print(fruitsSet.add("Melon")); // false
        print(fruitsSet); // [Apple, Melon, Banana]

        print(fruitsSet.add("Apple")); // false
        print(fruitsSet.add("Melon")); // false
        print(fruitsSet.add("Raspberry")); // true
        print(fruitsSet.add("Pear")); // true
        print(fruitsSet); // [Apple, Pear, Raspberry, Melon, Banana]

        title("Removing Data");
        print(fruitsSet.remove("Melon")); // true
        print(fruitsSet); // [Apple, Pear, Raspberry, Banana]

        title("Counting Data");
        print(fruitsSet.isEmpty()); // false
        print(fruitsSet.size()); // 4

        title("Check Contents");
        print(fruitsSet.contains("Strawberry")); // false

        title("Iterating");
        fruitsSet.forEach(System.out::println);

        title("Removing with Conditions");
        fruitsSet.removeIf(f -> f.equals("Banana"));
        print(fruitsSet); // [Apple, Pear, Raspberry]

        title("Determining Equality");
        System.out.println(fruitsSet.equals(new HashSet<>(fruitsSet))); // true

        title("Clearing the Collection");
        fruitsSet.clear();
        print(fruitsSet); // []
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
