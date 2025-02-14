package chapter_13_concurrency.p5_threading_problems;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Starvation ocorre quando uma thread nunca obtém acesso aos recursos
 * necessários porque outras threads monopolizam esses recursos.
 */
public class Starvation {
    private static final ReentrantLock lock = new ReentrantLock(true); // ⚠️ Remova "true" para ver starvation!

    static class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        public void run() {
            while (true) {
                if (lock.tryLock()) { // Se não conseguir o lock, a thread será ignorada
                    try {
                        System.out.println(Thread.currentThread().getName() + " obteve o lock.");
                        Thread.sleep(100); // Simula trabalho
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Worker("🔥 Thread Prioritária");
        Thread t2 = new Worker("🌱 Thread Baixa Prioridade");

        t1.setPriority(Thread.MAX_PRIORITY); // Dá alta prioridade para t1
        t2.setPriority(Thread.MIN_PRIORITY); // Dá baixa prioridade para t2

        t1.start();
        t2.start();
    }
}
