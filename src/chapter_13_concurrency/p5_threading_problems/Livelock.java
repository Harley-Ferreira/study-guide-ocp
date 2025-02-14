package chapter_13_concurrency.p5_threading_problems;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 Livelock ocorre quando duas ou mais threads continuam mudando de estado, mas nenhuma faz progresso.
 */
public class Livelock {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    static class Worker extends Thread {
        private final Lock firstLock;
        private final Lock secondLock;

        public Worker(String name, Lock firstLock, Lock secondLock) {
            super(name);
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        public void run() {
            while (true) {
                if (firstLock.tryLock()) {
                    try {
                        System.out.println(getName() + " Got Water");
                        if (secondLock.tryLock()) {
                            try {
                                System.out.println(getName() + " Got Food");
                                break; // 🔥 Finalmente conseguiu os dois locks!
                            } finally {
                                secondLock.unlock();
                            }
                        }
                    } finally {
                        firstLock.unlock();
                    }
                }
                // 🔄 Aqui as threads ficam presas tentando evitar deadlock, mas sem progresso real
                System.out.println(getName() + " liberou os locks e vai tentar de novo...");
                try {
                    Thread.sleep(100); // Simula tempo de espera antes de tentar novamente
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Worker("🦊 Foxy", lock1, lock2);
        Thread t2 = new Worker("🐺 Tail", lock2, lock1);

        t1.start();
        t2.start();
    }
}
