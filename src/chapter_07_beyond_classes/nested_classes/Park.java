package chapter_07_beyond_classes.nested_classes;

/**
 * NESTED CLASS
 * ------------
 * Static Nested Class:
 * Unlike an inner class, can be instantiated without an instance of the enclosing class.
 */
public class Park {

    static class Ride {
        private int price = 6;
    }

    public static void main(String[] args) {
        Ride ride = new Ride();
        System.out.println(ride.price);
    }
}
