package chapter_13_concurrency.p3_thread_safe_code;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class Ex8_CyclicBarrier {

    private void removeLions() {
        System.out.println(Thread.currentThread().getName() + " is Removing lions");
    }

    private void cleanPen() {
        System.out.println(Thread.currentThread().getName() + " is Cleaning the pen");
    }

    private void addLions() {
        System.out.println(Thread.currentThread().getName() + " is Adding lions");
    }
    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeLions();
            c1.await();
            cleanPen();
            c2.await();
            addLions();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        var service = Executors.newFixedThreadPool(4);
        try {
            var manager = new Ex8_CyclicBarrier();
            var c1 = new CyclicBarrier(4, () -> System.out.println("*** Lion Were Removed!"));
            var c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned!"));
            for (int i = 0; i < 4; i++) {
                service.submit(() -> manager.performTask(c1, c2));
            }
        } finally {
            service.shutdown();
        }

        // cyclicBarrierExample();
    }

    private static void cyclicBarrierExample() {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads,
                () -> System.out.println("Todas as threads chegaram na barreira!"));

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " está esperando na barreira.");
            try {
                barrier.await(); // Aguardando outras threads
                System.out.println(Thread.currentThread().getName() + " passou da barreira.");
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
        };

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(task).start();
        }
    }
}
