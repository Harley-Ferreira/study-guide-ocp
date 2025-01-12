package chapter_13_concurrency.p2_concurrency_api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex5_WaitingAllTaskFinish {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            makeSomething();
        } finally {
            service.shutdown();
        }

        System.out.println("waiting");
        service.awaitTermination(10, TimeUnit.SECONDS);

        if (service.isTerminated()) {
            System.out.println("Finished!");
        } else {
            System.out.println("At least one task is still running");
        }

        AwaitTerminationExample();
    }

    private static void makeSomething() {
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(printRecords).run();
    }

    /**
     * Cenário: Processamento em Lote de Arquivos Imagine que você está processando um lote de arquivos,
     * e deseja garantir que todas as tarefas sejam concluídas antes de encerrar o programa.
     */
    public static void AwaitTerminationExample() {
        System.out.println("\nAwaitTerminationExample");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Simulação de tarefas de processamento de arquivos
        for (int i = 1; i <= 5; i++) {
            int fileId = i;
            executor.submit(() -> {
                System.out.println("Processando arquivo: " + fileId);
                try {
                    Thread.sleep(2000); // Simula o tempo de processamento
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Arquivo " + fileId + " processado.");
            });
        }

        // Inicia o encerramento do executor
        executor.shutdown();
        try {
            // Aguarda no máximo 10 segundos pelo término das tarefas
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Nem todas as tarefas foram concluídas no tempo limite.");
                executor.shutdownNow(); // Força o encerramento
            } else {
                System.out.println("Todas as tarefas foram concluídas.");
            }
        } catch (InterruptedException e) {
            System.err.println("Thread principal foi interrompida.");
            executor.shutdownNow();
        }
    }
}
