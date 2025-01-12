package chapter_13_concurrency.p2_concurrency_api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Exemplo Comparativo
public class Concurrency {


    public static void main(String[] args) {

        semExecutorService();

        // Concurrency API
        comExecutorService();
    }

    private static void comExecutorService() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " executando");
            });
        }

        executor.shutdown();
    }

    private static void semExecutorService() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " executando");
            });
            thread.start();
        }
    }
}
