package chapter_13_concurrency.p1_introducing_thread;

/** POLLING WITH SLEEP - PAG. 727*/
public class Ex4_PollingWithSleep {

    private static int counter = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) counter++;
        }).start();

        while (counter < 1_000_000) {
            System.out.println("Not reached yet");
            try {
                Thread.sleep(1);  // Polling with sleep.
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }

        System.out.println("Reached: " + counter);
    }

    // SEE MORE: join() and yield()
}