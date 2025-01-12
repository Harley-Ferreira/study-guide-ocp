package chapter_13_concurrency.p3_thread_safe_code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** UNDERSTANDING THREAD-SAFETY
 * Thread safety is the property of an object that guarantees
 * safe execution by multiples threads at the same time.
 * Since threads run in a shared environment and memory space,
 * how do we prevent two threads from interfering with each other?
 */

// The code below IS NOT thread-safe
public class Ex1_ThreadSafety {
    private int sheepCount = 0;

    private void incrementAndReport() {
        System.out.print((++sheepCount) + " ");
    }

    /**
     * what does this program output in? It may in different order. Worse yet, it may print some numbers twice.
     *
     *            <- Reads sheepCount as 1                  Reads sheepCount as 1 ->
     * Thread One <----------------------->  Shared Memory <-----------------------> Thread Two
     *            Writes sheepCount as 2 ->                <- Writes sheepCount as 2
     *
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            Ex1_ThreadSafety manage = new Ex1_ThreadSafety();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manage.incrementAndReport());
            }
        } finally {
            service.shutdown();
        }
    }
}
