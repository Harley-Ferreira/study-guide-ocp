package chapter_08_lambdas_functional_interfaces.lambdas_method_references;

import java.util.List;

/**
 * Lambdas
 */
public class Exemple {

    public static void main(String[] args) {
        /*
        Valid lambdas that return a boolean
        Lambda                                      # of params
        () -> true                                      0
        x -> x.startWith("test")                        1
        (String x) -> x.startWith("test")               2
        (x, y) -> { return x.startWith("test"); }       3
        (String x, String y) -> x.startWith("test")     4
         */

        /*
        Invalid lambdas that should return a boolean
        Lambda                                      Reason
        x, y -> x.startWith("test")                 Missing parentheses on left
        x -> { x.startWith("test"); }               Missing return on right
        x -> { return x.startWith("test") }         Missing semicolon inside braces
        String x -> x.startWith("test")             Missing parentheses on left
         */

        List<String> fruits = List.of("apple", "banana", "oragle", "grapes", "strawberry");
        title("Lambda");
        fruits.stream().filter(fruit -> fruit.endsWith("e")).forEach(fruit -> System.out.println(fruit));
        title("Method Reference");
        fruits.stream().filter(Exemple::test).forEach(System.out::println);
    }

    private static boolean test(String fruit) {
        return fruit.endsWith("e");
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
