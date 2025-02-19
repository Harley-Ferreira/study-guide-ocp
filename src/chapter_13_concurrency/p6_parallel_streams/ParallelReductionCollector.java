package chapter_13_concurrency.p6_parallel_streams;

import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 🚀 O que é "Parallel Reduction on a Collector"?
 * Redução paralela ocorre quando usamos um Collector
 * (ex: toConcurrentMap) para agregar os valores de um Stream paralelo.
 * O Collectors.toConcurrentMap() permite que a operação de mapeamento
 * seja realizada simultaneamente em múltiplas threads.
 */
public class ParallelReductionCollector {

    public static void main(String[] args) {
        example1();
    }

    private static void example1() {
        Stream<String> stream = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = stream.collect(Collectors
                .toConcurrentMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(map);
        System.out.println(map.getClass());
    }
}
