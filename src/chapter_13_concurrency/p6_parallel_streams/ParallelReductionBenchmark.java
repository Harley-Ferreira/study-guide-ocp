package chapter_13_concurrency.p6_parallel_streams;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Streams paralelos podem melhorar o desempenho quando há muitos elementos e computação pesada.
 * Se os dados forem pequenos ou a sobrecarga de paralelismo for alta, o stream paralelo pode ser mais lento.
 * O paralelismo brilha quando há CPU multi-core e tarefas independentes.
 */
public class ParallelReductionBenchmark {
    public static void main(String[] args) {
        // Gerar 100.000 palavras aleatórias de tamanho 3 a 8
        List<String> words = generateRandomWords(100_000, 3, 8);

        // Medir tempo de execução do Stream sequencial
        long startSeq = System.nanoTime();
        Map<Integer, String> sequentialMap = words.stream()
                .collect(Collectors.toMap(
                        String::length,
                        k -> k,
                        (s1, s2) -> s1 + "," + s2
                ));
        long timeSeq = System.nanoTime() - startSeq;

        // Medir tempo de execução do Stream paralelo
        long startPar = System.nanoTime();
        ConcurrentMap<Integer, String> parallelMap = words.parallelStream()
                .collect(Collectors.toConcurrentMap(
                        String::length,
                        k -> k,
                        (s1, s2) -> s1 + "," + s2
                ));
        long timePar = System.nanoTime() - startPar;

        // Exibir os tempos
        System.out.println("Tempo (Sequencial): " + timeSeq / 1_000_000 + " ms");
        System.out.println("Tempo (Paralelo):   " + timePar / 1_000_000 + " ms");
    }

    // Método para gerar palavras aleatórias
    private static List<String> generateRandomWords(int count, int minLength, int maxLength) {
        Random random = new Random();
        return IntStream.range(0, count)
                .mapToObj(i -> random.ints('a', 'z' + 1)
                        .limit(random.nextInt(maxLength - minLength + 1) + minLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString())
                .toList();
    }
}
