package chapter_09_collections_generics.map;

import java.util.HashMap;

/**
 * - Map Interface -
 * Use a map when you want to identify value by a key
 * -
 * HashMap -> the main benefits is that adding elements and retrieving
 * the element by a key both have constant time. The trade-off you lose
 * the order in which you inserted the elements.
 * -
 * TreeMap -> stores the keys in a sorted tree structure.
 * The trade-off is that adding and checking whether a
 * key is present takes longer as the tree grows larger
 */
public class ExampleHashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        title("Adding data");
        map.put("lion", "meat");
        map.put("monkey", "banana");
        map.put("giraffe", "leaf");
        print(map); // {monkey=banana, giraffe=leaf, lion=meat}

        title("Getting data");
        print(map.get("lion")); // meat
        print(map.getOrDefault("lion", "water")); // meat
        print(map.get("hippo")); // null
        print(map.getOrDefault("hippo", "water")); // water

        title("Iterating through a Map");
        map.forEach((k, v) -> System.out.println(k + " eats " + v));

        title("Removing data");
        print(map.remove("giraffe"));
        print(map); // {monkey=banana, lion=meat}

        title("Putting if Absent");
        /* The putIfAbsent() method sets a value in the map but
        skits it if the value is already set to a non-null value.*/
        map.putIfAbsent("lion", "roast meat");
        map.put("panda", null);
        print(map); // {panda=null, monkey=banana, lion=meat}
        map.putIfAbsent("panda", "bamboo");
        print(map); // {panda=bamboo, monkey=banana, lion=meat}


        title("Replacing values");
        map.replace("lion", "barbecue");
        print(map); // {panda=bamboo, monkey=banana, lion=barbecue}

        title("Merging Data");
        // Merge let us add a logic of what to choose. For example consider the small length.
        map.merge("lion", "meat", (v1, v2) -> v1.length() > v2.length() ? v2 : v1);
        print(map); // {panda=bamboo, monkey=banana, lion=meat}

        title("Replacing all values");
        map.replaceAll((k, v) -> v.toUpperCase());
        print(map);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
