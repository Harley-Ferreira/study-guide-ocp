package chapter_05_methods;

/**
 * Design Methods
 */
public class Exemplo1 {

    // Access Modifiers - private, protected, package access  and public

    /**
     * Optional Specifiers
     * static
     * abstract
     * final
     * default
     * synchronized - Used with multithreaded code
     * native - Used when interacting with code written in another language, such as C++
     * strictfp - Used for making floating-point calculations portable (out of scope)
     */

    // Static Initializer
    static {
        print("SOMETHING");
    }

    /**
     * Autoboxing and Unboxing Variables
     * Java has handles built into the java language that automatically
     * convert between  primitives and Wrapper classes and back again
     */

    public static void main(String[] args) {
        print("Design Methods");

        // Effectively Final Variables
        final String name = "Hippo"; // Is effectively final
        var size = 5; // Is not effectively final
        final boolean equals; // Is Effectively final
        if (name.length() == size) {
            equals = true;
        } else {
            equals = false;
        }
        size = 0;
        print(equals);
    }


    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
