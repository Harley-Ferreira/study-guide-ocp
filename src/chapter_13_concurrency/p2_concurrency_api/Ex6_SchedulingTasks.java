package chapter_13_concurrency.p2_concurrency_api;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.*;

public class Ex6_SchedulingTasks {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";
        ScheduledFuture<?> r1 = service.schedule(task1, 5, TimeUnit.SECONDS);
        // service.shutdown(); If we shutdown de service, so r1 will be executed but not r2, also an exception is executed when try to execute r2.
        ScheduledFuture<String> r2 = service.schedule(task2, 8, TimeUnit.SECONDS);
        System.out.println(r2.get());

        SingleThreadScheduledExecutorExample();
    }

    /**
     * Se more
     * Executors.newCachedThreadPool();
     * Executors.newFixedThreadPool();
     */


    /**
     * Cenário: Notificação Regular de Backup Imagine que você deseja implementar um sistema
     * que verifica e notifica a cada 5 segundos que o backup está em andamento.
     */
    public static void SingleThreadScheduledExecutorExample () {
        System.out.println("\nSingleThreadScheduledExecutorExample");
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // Agendando uma tarefa repetitiva para notificação
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Backup em andamento... " + new Date(System.currentTimeMillis()));
        }, 0, 10, TimeUnit.SECONDS);

        // Agendando o encerramento após 20 segundos
        scheduler.schedule(() -> {
            System.out.println("Encerrando o agendador...");
            scheduler.shutdown();
        }, 5, TimeUnit.SECONDS);

        // Monitorando o encerramento
        try {
            if (!scheduler.awaitTermination(25, TimeUnit.SECONDS)) {
                System.out.println("Forçando o encerramento do agendador.");
                scheduler.shutdownNow();
            } else {
                System.out.println("Agendador encerrado com sucesso.");
            }
        } catch (InterruptedException e) {
            System.err.println("Thread principal foi interrompida.");
            scheduler.shutdownNow();
        }
    }
}
