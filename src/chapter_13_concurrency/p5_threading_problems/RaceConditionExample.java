package chapter_13_concurrency.p5_threading_problems;

public class RaceConditionExample {
    private static int counter = 0; // Variável compartilhada

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++; // ⚠️ Não é seguro para múltiplas threads!
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++; // ⚠️ Modificando a mesma variável ao mesmo tempo
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final do contador: " + counter); // Deveria ser 20000, mas pode ser menor!
    }
}
