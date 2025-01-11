package chapter_10_streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreams {
    /**
     * The error stream has already been operated upon or closed occurs because a Stream in Java
     * can only be operated upon once. After a terminal operation (e.g., collect, forEach, count)
     * is performed, the Stream is considered consumed or closed, and you cannot reuse it.
     * Therefore, it is being created a stream for each example. We can use a List instead.
     */

    /**
     * Terminal Stream Operation
     */
    public static void main(String[] args) {
        title("Counting");
        Stream<String> fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        print(fruitStream.count()); // 6

        title("Minimum and Maximum");
        // print the first
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        fruitStream.min(Comparator.comparingInt(String::length)).ifPresent(BasicStreams::print); // Apple
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        fruitStream.max(Comparator.comparingInt(String::length)).ifPresent(BasicStreams::print); // Pineapple

        title("Finding a value");
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        print(fruitStream.findAny());

        title("Matching");
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        print(fruitStream.allMatch(fruit -> fruit.startsWith("M")));

        title("Iterating");
        // it's not possible to use a traditional for loop on a stream
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        fruitStream.forEach(System.out::println);

        title("Reducing");
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        String reduce = fruitStream.reduce("", (fruit, acumulator) -> fruit + acumulator + " is a good fruit.\n");
        System.out.println(reduce); // Apple is a good fruit.\n Banana is a good fruit.\n ...

        title("Collecting");
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        Map<Integer, List<String>> collect = fruitStream.collect(Collectors.groupingBy(String::length));
        print(collect); // {5=[Apple, Mango], 6=[Banana, Cherry, Orange], 9=[Pineapple]}

        /**
         * Using Common Intermediate Operations
         * Unlike a terminal operation, an intermediate operation produce a stream as its result
         */
        title("Filtering");
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        List<String> fruits = fruitStream.filter(fruit -> fruit.endsWith("e")).collect(Collectors.toList());
        print(fruits); // [Apple, Orange, Pineapple]

        title("Removing Duplicates");
        fruitStream = Stream.of("Apple", "Banana", "Banana", "Cherry", "Mango", "Mango", "Orange", "Pineapple");
        fruits = fruitStream.distinct().collect(Collectors.toList());
        print(fruits); // [Apple, Banana, Cherry, Mango, Orange, Pineapple]

        title("Restrictiong by Position");
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        fruits = fruitStream.skip(3).limit(2).collect(Collectors.toList());
        print(fruits); // [Mango, Orange]
        print(Stream.iterate(1, n -> n + 1).skip(4).limit(3).collect(Collectors.toList())); // [5, 6, 7]

        title("Mapping");
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        fruitStream.map(String::length).forEach(System.out::print); // 566569

        title("Using flatMap");
        var fruitList1 = List.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        var fruitList2 = List.of("Strawberry", "Guava", "Papaya");
        Stream<List<String>> fruitsStream = Stream.of(fruitList1, fruitList2);
        fruitsStream.flatMap(f -> f.stream().map(String::length)).forEach(f -> System.out.print(f + " - ")); // 5 - 6 - 6 - 5 - 6 - 9 - 10 - 5 - 6

        title("Sorting");
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        fruits = fruitStream.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        print(fruits); // [Pineapple, Orange, Mango, Cherry, Banana, Apple]

        title("Peek");
        // Use peek for help to debug
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        long count = fruitStream.filter(fruit -> fruit.endsWith("e"))
                .peek(System.out::println).count();
        print(count);

        title("Joining");
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        print(fruitStream.collect(Collectors.joining(" - ")));

        title("Spliterator");
        // O Spliterator em Java é uma interface usada para dividir e iterar elementos de uma coleção de forma eficiente,
        // especialmente em ambientes que utilizam paralelismo. Ele combina as funcionalidades de um iterador tradicional
        // (Iterator) com a capacidade de dividir a estrutura de dados em partes menores para processamento paralelo.
        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Mango", "Orange", "Pineapple");
        Spliterator<String> spliterator = fruitStream.spliterator();

        // Verificar características
        print("Characteristics: " + spliterator.characteristics());
        print("Estimate size: " + spliterator.estimateSize());

        // Dividir a coleção
        Spliterator<String> secondSpliterator = spliterator.trySplit();

        // Processar a primeira parte
        print("\n");
        print("First Spliterator:");
        spliterator.forEachRemaining(s -> System.out.print(s + " ")); // Mango Orange Pineapple

        // Processar a segunda parte
        if (secondSpliterator != null) {
            print("\n");
            print("Second Spliterator:");
            secondSpliterator.forEachRemaining(s -> System.out.print(s + " ")); // Apple Banana Cherry
        }

    }



    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
