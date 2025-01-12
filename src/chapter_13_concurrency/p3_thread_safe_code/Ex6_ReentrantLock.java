package chapter_13_concurrency.p3_thread_safe_code;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * REENTRANTLOCK - PAG. 747
 * ReentrantLock é uma alternativa ao uso de blocos sincronizados (synchronized)
 * para gerenciar acesso a recursos compartilhados entre threads.
 */
public class Ex6_ReentrantLock {
    private final ReentrantLock lock = new ReentrantLock();
    private int sharedResource = 0;

    public void increment() {
        lock.lock(); // Adquirindo o lock
        try {
            sharedResource++;
            System.out.println(Thread.currentThread().getName() + " incrementou: " + sharedResource);
        } finally {
            lock.unlock(); // Liberando o lock
        }
    }
    public static void main(String[] args) {

        Ex6_ReentrantLock example = new Ex6_ReentrantLock();

        Runnable task = example::increment;

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }


}
