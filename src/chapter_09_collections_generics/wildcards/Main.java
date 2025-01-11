package chapter_09_collections_generics.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * REMEMBER THIS TABLE BELOW IS VERY USEFUL
 * Type                          Syntax          Example
 * Unbounded wildcard            ?               List<?> a = new ArrayList<String>();
 * Wildcard with upper           ? extends type  List<? extends Exception> a = new ArrayList<RuntimeException>();
 * Wildcard with lower bound     ? super type    List<? super Exception> a = new ArrayList<Object>();
 */
public class Main {

    public static void main(String[] args) {
        title("Example 1");
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(34);
        numbers.add(74);
        printList(numbers);

        title("Example 2");
        printTotal(numbers);
        // printTotal(keywords); Don't compile, because String is not a subclass of Number

        title("Example 3");
        // List<Customer> people = new ArrayList<>(); // Don't compile because de super class is Person or Object
        List<Object> people = new ArrayList<>();
        addEmployees(people);
        System.out.println("Contents of the list:");
        printList(people);

    }


    // Unbounded wildcard
    public static void printList(List<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    // Wildcard with upper
    public static void printTotal(List<? extends Number> list) {
        double count = 0;
        for (Number number : list) {
            count += number.doubleValue();
        }
        System.out.println(count);
    }

    // Wildcard with lower bound
    public static void addEmployees(List<? super Employee> list) {
        list.add(new Employee("John Doe"));
        list.add(new Employee("John Smith"));
    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person: " + name;
        }
    }

    static class Employee extends Person {
        public Employee(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Employee: " + name;
        }
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
