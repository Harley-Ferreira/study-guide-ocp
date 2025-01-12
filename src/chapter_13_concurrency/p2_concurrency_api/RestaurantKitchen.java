package chapter_13_concurrency.p2_concurrency_api;

import java.util.concurrent.*;

/**
 * Scenario: Restaurant Kitchen with Chefs and Orders
 * - Chefs: Threads that execute tasks.
 * - Orders: Tasks submitted for execution.
 * - Order Queue: A shared pool for pending orders.
 */
public class RestaurantKitchen {
    // A task representing a chef preparing a dish
    static class DishPreparation implements Callable<String> {
        private final String order;

        public DishPreparation(String order) {
            this.order = order;
        }

        @Override
        public String call() throws InterruptedException {
            System.out.println("Chef " + Thread.currentThread().getName() + " started preparing: " + order);
            // Simulate time taken to prepare the dish
            Thread.sleep((int) (Math.random() * 3000) + 1000);
            System.out.println("Chef finished preparing: " + order);
            return order + " is ready!";
        }
    }

    /*
     * Explanation
     * Thread Pool: Executors.newFixedThreadPool(3) creates a pool of 3 threads, simulating 3 chefs.
     * Callable: The DishPreparation class implements Callable<String> to represent tasks that return results.
     * Future: Each submitted task returns a Future object, which allows tracking the task's status and retrieving its result.
     * Simulation: The Thread.sleep call simulates the time required to prepare each dish.
     */
    public static void main(String[] args) {
        // Create a thread pool representing available chefs
        ExecutorService kitchen = Executors.newFixedThreadPool(3);

        // Sample orders from customers
        String[] orders = {"Pasta", "Pizza", "Salad", "Burger", "Soup", "Sushi", "Tacos"};

        // Store Future objects to retrieve results later
        Future<String>[] results = new Future[orders.length];

        try {
            // Submit orders to the kitchen
            for (int i = 0; i < orders.length; i++) {
                results[i] = kitchen.submit(new DishPreparation(orders[i]));
            }

            // Retrieve and display the results
            for (Future<String> result : results) {
                try {
                    // Wait for the task to complete and get the result
                    System.out.println(result.get());
                } catch (ExecutionException | InterruptedException e) {
                    System.err.println("Error processing order: " + e.getMessage());
                }
            }
        } finally {
            // Shut down the kitchen
            kitchen.shutdown();
            System.out.println("Kitchen is closed for the day!");
        }
    }
}
