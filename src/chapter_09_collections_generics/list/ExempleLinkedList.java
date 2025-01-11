package chapter_09_collections_generics.list;

import java.util.LinkedList;

/**
 * The main benefits of LinkedList are that you can access, add to,
 * and remove from the beginning and end of the list in constant time.
 */

public class ExempleLinkedList {
    public static void main(String[] args) {
        var linkedList = new LinkedList<String>();

        title("Adding Data");
        linkedList.add("door");
        linkedList.addFirst("window");
        linkedList.add("window");
        linkedList.addFirst("armchair");
        linkedList.addLast("fridge");
        linkedList.add("pan");
        print(linkedList); // [armchair, window, door, window, fridge, pan]

        title("Removing Data");
        linkedList.remove("windown");
        linkedList.removeFirst();
        linkedList.removeLast();
        print(linkedList); // [window, door, window, fridge]

        title("Reading Data");
        print(linkedList.getFirst()); // window
        print(linkedList.getLast()); // fridge
        print(linkedList.element()); // equals getFist
        print(linkedList.get((linkedList.size() - 1) / 2)); // door
        print(linkedList); // [window, door, window, fridge]

        print(linkedList.peekFirst()); // window
        print(linkedList.peekLast()); // fridge
        print(linkedList); // [window, door, window, fridge]
        // get and remove
        print(linkedList.pollFirst()); // window
        print(linkedList.pollLast()); // fridge
        print(linkedList); // [door, window]
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }

}
