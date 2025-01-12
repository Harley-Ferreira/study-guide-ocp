package chapter_13_concurrency.p2_concurrency_api;

import java.util.concurrent.*;

/**
 * The Callable interface is often preferable over Runnable, since it allows more details
 * to be retrieved easily from the task after it is completed.
 */
public class Ex4_Callable {
    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> result = service.submit(() -> 30 + 11);
            System.out.println(result.get());
        } finally {
            service.shutdown();
        }

        mainRunnable();
        mainCallable();
    }

    /** 1. Definição Básica
    - Runnable
        Uma interface funcional usada para definir uma tarefa que pode ser executada por uma thread,
        mas não retorna valor nem lança exceções verificadas.
    - Callable
        Uma interface funcional usada para definir uma tarefa que pode ser executada por uma thread
        e retorna um valor e pode lançar exceções verificadas.
    */

    // Exemplo abaixo mostra como são usadas.
    public static void mainRunnable() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " está executando a tarefa.");
        };

        var a = executor.submit(task);
        try {
            System.out.println(a.get()); // null, porque não retorna valor
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }

    public static void mainCallable() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<String> task = () -> {
            Thread.sleep(1000); // Simula uma tarefa demorada
            return Thread.currentThread().getName() + " completou a tarefa!";
        };

        try {
            Future<String> future = executor.submit(task);
            System.out.println("Resultado: " + future.get()); // Obtém o resultado da tarefa
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
