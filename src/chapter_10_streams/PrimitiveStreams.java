package chapter_10_streams;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreams {

    public static void main(String[] args) {
        title("Int Stream");
        IntStream intStream = IntStream.iterate(0, n -> n + 10).limit(5);
        intStream.forEach(i -> System.out.print(i + " ")); // 0 10 20 30 40
        IntStream intStream2 = IntStream.of(10, 20, 35, 56, 44);
        print("");
        print(intStream2.summaryStatistics()); // IntSummaryStatistics{count=5, sum=165, min=10, average=33,000000, max=56}

        title("Double Stream");
        DoubleSummaryStatistics doubleSummaryStatistics = DoubleStream.generate(Math::random).limit(10).summaryStatistics();
        print(doubleSummaryStatistics);

        title("Long Stream");
        LongStream longStream = LongStream.rangeClosed(1, 10);
        System.out.println(longStream.boxed().toList());
        DoubleStream d = LongStream.range(1, 4).mapToDouble(value -> value);
        d.forEach(System.out::println);

        var result = LongStream.of(6L, 8L, 10L)
                .mapToInt(x -> (int) x)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.toSet()))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x -> x));
        print(result);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
