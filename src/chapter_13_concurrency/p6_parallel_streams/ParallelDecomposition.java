package chapter_13_concurrency.p6_parallel_streams;

import java.util.List;

/**
 * A parallel decomposition is the precess of taking a task,
 * breaking it into smaller pieces that can be performed
 * concurrently, and then reassembling the results.
 * */
public class ParallelDecomposition {
    private static int doWork(int input) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        return input;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List.of(1, 2, 3, 4, 5).stream().map(w -> doWork(w)).forEach(s -> System.out.print(s + " "));
        System.out.println();
        var timeTaken = (System.currentTimeMillis() - start) / 1000;
        System.out.printf("Time: %d seconds%n", timeTaken);
        // RESULT: 1 2 3 4 5 Time: 25 seconds

        long start2 = System.currentTimeMillis();
        List.of(1, 2, 3, 4, 5).parallelStream().map(w -> doWork(w)).forEach(s -> System.out.print(s + " "));
        System.out.println();
        var timeTaken2 = (System.currentTimeMillis() - start2) / 1000;
        System.out.printf("Time: %d seconds%n", timeTaken2);
        // RESULT: 3 1 2 4 5 Time: 5 seconds (The result are no longer ordered or predictable)
    }
}
