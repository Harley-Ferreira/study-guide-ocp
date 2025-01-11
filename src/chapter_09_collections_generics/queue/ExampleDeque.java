package chapter_09_collections_generics.queue;

import java.util.Deque;
import java.util.LinkedList;

public class ExampleDeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        //OBS: offer equals to offerLast and add equals to addLast
        title("Adding data");
        deque.add("João"); // true
        deque.offer("Maria"); // true
        deque.addFirst("Silvia"); // true
        deque.addFirst("Maike"); // true
        deque.offerFirst("Harley"); // true
        deque.offerLast("Marcos"); // true
        deque.add("Clara"); // true
        print(deque); // [Harley, Maike, Silvia, João, Maria, Marcos, Clara]

        //OBS: remove equals to removeFist and poll equals to pollFirst
        title("Removing data");
        print(deque.removeLast()); // João
        print(deque.remove()); // Maria
        print(deque.poll()); // Silvia
        print(deque); // [Silvia, João, Maria, Marcos]

        title("Reading data");
        // get the head value
        print(deque.peek()); // Silvia
        print(deque); // [Silvia, João, Maria, Marcos]
        // get the head value
        print(deque.element()); // Silvia
        print(deque.getFirst()); // Silvia
        print(deque.getLast()); // Marcos
        print(deque.peekLast()); // Marcos
        print(deque); // [Silvia, João, Maria, Marcos]

        deque.removeIf(v -> v.length() > 6);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
