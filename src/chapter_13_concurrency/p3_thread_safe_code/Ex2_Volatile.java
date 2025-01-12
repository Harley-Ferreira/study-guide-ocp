package chapter_13_concurrency.p3_thread_safe_code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Volatile provide thread-safety? Not exactly.
// In practice, 'volatile' is rarely used.

/**
 * Características do volatile
 * Visibilidade de memória:
 * Uma variável marcada como volatile é sempre lida da memória principal (heap) e não de um cache local de thread.
 * Isso garante que todas as threads tenham uma visão consistente do valor atualizado.
 * ---------------------------------------------------------------------------------------------------------------------
 * Quando Usar volatile?
 * Use volatile quando:
 * Uma variável é acessada e atualizada por várias threads, mas:
 * As operações realizadas na variável são simples (ex.: leitura/escrita).
 * Não há necessidade de atomicidade (ex.: incrementos ou decrementos complexos exigem sincronização adicional).
 */

// The code below is thread-safe
public class Ex2_Volatile {
    private volatile int sheepCount = 0;

    private void incrementAndReport() {
        System.out.print((++sheepCount) + " ");
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            Ex2_Volatile manage = new Ex2_Volatile();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manage.incrementAndReport());
            }
        } finally {
            service.shutdown();
        }
    }
}
