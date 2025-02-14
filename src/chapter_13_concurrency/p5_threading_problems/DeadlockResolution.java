package chapter_13_concurrency.p5_threading_problems;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class DeadlockResolution {

    static class Food {
        final Lock lock = new ReentrantLock();
    }

    static class Water {
        final Lock lock = new ReentrantLock();
    }

    public record Foxy(String name) {
        public void eatAndDrink(Food food, Water water) {
            while (true) {
                try {
                    if (food.lock.tryLock(100, TimeUnit.MILLISECONDS)) { // 🔒 Tenta pegar comida
                        try {
                            System.out.println(name() + " Got Food!");
                            move();

                            if (water.lock.tryLock(100, TimeUnit.MILLISECONDS)) { // 🔒 Tenta pegar água
                                try {
                                    System.out.println(name() + " Got Water!");
                                    break; // Conseguiu ambos os recursos
                                } finally {
                                    water.lock.unlock();
                                }
                            }
                        } finally {
                            food.lock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // 🔄 Espera um pouco e tenta de novo
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void move() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public static void main(String[] args) {
            var foxy = new Foxy("Foxy");
            var tail = new Foxy("Tail");
            var food = new Food();
            var water = new Water();

            var service = Executors.newScheduledThreadPool(10);
            try {
                service.submit(() -> foxy.eatAndDrink(food, water));
                service.submit(() -> tail.eatAndDrink(food, water));
            } finally {
                service.shutdown();
            }
        }
    }
}
