package chapter_13_concurrency.p2_concurrency_api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Concurrency
 * -
 * When writing multi-threaded programs is practice, it is often better
 * to use the Concurrency API rather than work with Thread object directly.
 */
public class Ex1_SingleThreadExecutor {

    // CREATE A MANAGE THREADS, UNLIKE THE LAST EXAMPLE, IN THIS WE HAVE JUST ONE THREAD
    public static void main(String[] args) {

        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };

        /**
         * - A thread executor creates a non-daemon thread on the first task that is executed,
         * so failing to call shutdown() will result in your application never terminating.
         * - When we are using execute() we submit a task.
         * - We can submit tasks to an ExecuteService instance multiple ways.
         */
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            System.out.println("begin");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            System.out.println("end");
        } finally {
            service.shutdown();
        }
    }
}
