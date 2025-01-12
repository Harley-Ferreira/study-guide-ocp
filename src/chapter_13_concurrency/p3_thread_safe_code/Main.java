package chapter_13_concurrency.p3_thread_safe_code;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class ComplexCounter {
    private volatile boolean active = true;
    private AtomicInteger count = new AtomicInteger(0); // Variável atômica para contagem

    public void stop() {
        active = false; // Mudança simples de variável
    }

    // Método sincronizado para garantir que operações de incremento sejam atômicas
    public void increment() {
        System.out.println("SET: " + Thread.currentThread().getName());

        if (active) {
            count.incrementAndGet(); // Incremento atômico
        }
    }

    public int getCount() {
        System.out.println("GET: " + Thread.currentThread().getName());
        return count.get(); // Leitura atômica
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ComplexCounter counter = new ComplexCounter();

        // Criando o ExecutorService com um número fixo de threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Enviando tarefas para o ExecutorService
        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
            }
        });

        // Aguardar a execução das tarefas
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Imprimir o valor final do contador
        System.out.println("Contagem final: " + counter.getCount());

        // Parando o contador
        counter.stop();

        // Tentando incrementar novamente após parar
        counter.increment();
        System.out.println("Contagem após parada: " + counter.getCount());
    }
}
