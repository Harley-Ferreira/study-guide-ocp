package chapter_08_lambdas_functional_interfaces.funtional_interfaces;

import java.time.LocalDate;
import java.util.function.*;

// Functional Interfaces
// There are a large number of general-purpose functional interfaces.
public class Example {
    public static void main(String[] args) {

        // Supplier is used when you want to generate or supply values without taking any input.
        title("SUPPLIER");
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        print(d1);
        print(d2);

        // Consumer is used when you want to do something with a parameter but not return anything.
        title("CONSUMER");
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        c1.accept("Harley"); // Harley
        c2.accept("Harley"); // Harley

        // Predicate is ofter used when filtering or matching.
        title("PREDICATE");
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        print(p1.test("")); // true
        print(p2.test("")); // true
        print(p1.and(p2).test("Something")); //true
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");
        // s -> s.contains("egg") && s.contains("brown") equals egg.and(brown).test("egg")
        print(egg.and(brown).test("egg"));

        // BiPredicate is like predicate, except that it takes two parameters.
        title("BI PREDICATE");
        BiPredicate<String, String> bp1 = String::startsWith;
        BiPredicate<String,String> bp2 = (string, prefix) -> string.startsWith(prefix);
        print(bp1.test("chicken", "chick")); // true
        print(bp2.test("chicken", "chick")); // true

        // Function is responsible for turning one parameter into value of a potentially different type and returning.
        title("FUNCTION");
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();
        print(f1.apply("cluck")); // 5
        print(f2.apply("cluck")); // 5

        // BiFunction is responsible for turning two parameters into a value and returning it
        title("BI FUNCTION");
        BiFunction<String, String, String> bf1 = String::concat;
        BiFunction<String, String, String> bf2 = (string, toAdd) -> string.concat(toAdd);
        print(bf1.apply("Harley ", "Ferreira")); // Harley Ferreira
        print(bf2.apply("Harley ", "Ferreira")); // Harley Ferreira

        // UnaryOperator and BinaryOperator are special cases od a Function.
        // They required all type to be the same type.
        title("UNARY OPERATOR");
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        print(u1.apply("maria")); // MARIA
        print(u2.apply("maria")); // MARIA

        title("BINARY OPERATOR");
        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
        print(b1.apply("Harley ", "Ferreira")); // Harley Ferreira
        print(b2.apply("Harley ", "Ferreira")); // Harley Ferreira

        /**
         * There are another types of functional interfaces, below are some:
         * DoubleSupplier
         * IntSupplier
         * LongSupplier
         * ---------------
         * DoubleConsumer
         * IntConsumer
         * LongConsumer
         * ---------------
         * DoublePredicate
         * IntPredicate
         * LongPredicate
         * ---------------
         * DoubleFunction
         * IntFunction
         * LongFunction
         */
        title("DOUBLE TO INT FUNCTION");
        var z = 2.0;
        DoubleToIntFunction y = x -> (int) x;
        print(y.applyAsInt(z));
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
