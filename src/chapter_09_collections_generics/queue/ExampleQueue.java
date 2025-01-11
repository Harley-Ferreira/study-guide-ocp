package chapter_09_collections_generics.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  - Queue -
 *  Use a Queue when elements are added and removed in a specific order.
 *  You can think of queue as a line. FIFO (first-in, first-out)
 *  -
 *  A Deque (double-ended queue), you can insert or remove elements for both the front and back.
 */
public class ExampleQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        title("Adding data");
        queue.add("João"); // true
        queue.offer("Maria"); // true
        queue.add("Silvia"); // true
        queue.add("Maike"); // true
        queue.add("Harley"); // true
        queue.add("Marcos"); // true
        queue.add("Clara"); // true
        print(queue); // [João, Maria, Silvia, Maike, Harley, Marcos, Clara]

        title("Removing data");
        print(queue.remove()); // João
        print(queue.remove()); // Maria
        print(queue.poll()); // Silvia
        print(queue); // [Maike, Harley, Marcos, Clara]

        title("Reading data");
        // get the head value
        print(queue.peek()); // Maike
        print(queue); // [Maike, Harley, Marcos, Clara]
        // get the head value
        print(queue.element()); // Maike
        print(queue); // [Maike, Harley, Marcos, Clara]
    }
    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
