package chapter_04_core_apis;

/**
 * Creating and Manipulating Strings
 */
public class Example1 {
    public static void main(String[] args) {
        String animal = "Hippo";

        title("Determining the Length");
        print(animal.length()); // 5

        title("Getting a Single Character");
        print(animal.charAt(0)); // H
        print(animal.charAt(4)); // o
        // .charAt(5) will throw an exception

        title("Finding an Index");
        print(animal.indexOf('p')); // 2
        print(animal.indexOf('p', 3)); // 3

        title("Getting a Substring");
        print(animal.substring(2)); // ppo
        print(animal.substring(2, 4)); // pp

        title("Adjusting Case");
        print(animal.toLowerCase()); // hippo
        print(animal.toUpperCase()); // HIPPO

        title("Checking for Equality");
        print(animal.equals("HIPPO")); // false
        print(animal.equalsIgnoreCase("HIPPO")); // false

        title("Searching for Substrings");
        print(animal.startsWith("h")); // false
        print(animal.equals("o")); // true
        print(animal.contains("H")); // true

        title("Replacing Values");
        print(animal.replace("H", "h"));
        print(animal.replace("o", "opotamus"));

        title("Removing Whitespace");
        print(" H i p p o ".strip().length()); // (H i p p o) - 9 characters
        print(" H i p p o ".stripLeading().length()); // (H i p p o ) - 10 characters
        print(" H i p p o ".stripTrailing().length()); // ( H i p p o) - 10 characters
        print(" H i p p o ".trim().length()); // (H i p p o) - 9 characters

        title("Working with Indentation");


        title("Translating Escapes");
        var str = "1\\tHippo";
        print(str); // 1\tHippo
        print(str.translateEscapes()); // 1	Hippo

        title("Checking for Empty or Blank Strings");
        print(" ".isEmpty()); // false
        print(" ".isBlank()); // true

        title("Formatting Values");
        print(String.format("The %s eats %d pumpkins a day.", animal, 9)); // The Hippo eats 9 pumpkins a day
        print("The %s eats %d pumpkins a day.".formatted(animal, 9)); // The Hippo eats 9 pumpkins a day

        title("String Builder Class");
        var s = new StringBuilder("Hippo");
        s.append(" eats pumpkin");
        print(s); // Hippo eats pumpkin
        s.insert(10, " 10");
        print(s); // Hippo eats 10 pumpkin
        s.delete(10, 13);
        print(s); // Hippo eats pumpkin
        print(s.reverse()); // nikpmup stae oppiH

        title("The String Pool");
        var x = "Hello World";
        var y = "Hello World";
        print(x == y); // true
        var z = "Hello World ".trim();
        print(x == z); // false
        var w = new String("Hello World");
        print(x == w); // false
        print(x == w.intern()); // true
        // The String Pool is a location in the JVM that collects all string initialized literally.

    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
