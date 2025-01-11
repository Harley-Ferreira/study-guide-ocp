package chapter_11_exceptions_localization.exception;

import java.io.IOException;

/**
 * A checked exception is an exception that must be declared
 * or handled by the application code where it is thrown
 * In Java, checked exception all inherit Exception but not RuntimeException
 * *
 * Em Java, as exceções são classificadas em Checked Exceptions (exceções verificadas).
 * Checked Exceptions (Exceções Verificadas)
 * Definição:
 * São exceções que o compilador exige que sejam tratadas ou declaradas.
 * Isso significa que, ao usar métodos que podem lançar essas exceções, você deve obrigatoriamente:
 * - Tratar a exceção com um bloco try-catch, ou
 * - Declarar a exceção com throws na assinatura do método.
 * *
 * Exemplos de Checked Exceptions:
 * - IOException
 * - SQLException
 * - FileNotFoundException
 * *
 * Características:
 * - Representam problemas que podem ser previstos e recuperados pelo programa.
 * - O compilador verifica se você tratou ou declarou essas exceções.
 */
public class CheckedExceptions {
    public static void main(String[] args) {
        CheckedExceptions ex = new CheckedExceptions();
        try {
            ex.fall(10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void fall(int distance) throws IOException {
        if (distance > 10) {
            throw new IOException();
        }
    }

    /*
    ---- Commons CheckedException ----
        FileNotFoundException
        IOException
        ParseException
        SQLException
     */
}
