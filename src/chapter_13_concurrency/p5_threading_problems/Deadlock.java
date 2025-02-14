package chapter_13_concurrency.p5_threading_problems;

import java.util.concurrent.Executors;

/**
 * Imagine that our zoo has two foxes> Foxy and Tail.
 * Foxy likes to eat first and then drink water,
 * while, Tails likes to drink water first and then eat.
 * Furthermore, neither animal like to share,
 * and they will finish their meal only if they have exclusive access to both food and water.
 * -------------------------------------
 * Problema do Deadlock
 * 1 - Foxy bloqueia comida, depois tenta bloquear água.
 * 2 - Tails bloqueia água, depois tenta bloquear comida.
 * 3 - Nenhuma das raposas libera os recursos que já adquiriram, causando um deadlock.
 */
public class Deadlock {

    static class Food {
    }

    static class Water {
    }

    public record Foxy(String name) {
        public void eatAndDrink(Food food, Water water) {
            synchronized (food) {
                System.out.println(name() + " Got Food!");
                move();
                synchronized (water) {
                    System.out.println(name + "Got Water!");
                }
            }
        }

        public void drinkAndEat(Food food, Water water) {
            synchronized (water) {
                System.out.println(name() + " Got Water!");
                move();
                synchronized (food) {
                    System.out.println(name + "Got Food!");
                }
            }
        }

        public void move() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
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
                service.submit(() -> tail.drinkAndEat(food, water));
            } finally {
                service.shutdown();
            }
        }
    }

    /* This example is considered a deadlock because both participants are permanently blocked,
    waiting on resources that will never become available */

}
