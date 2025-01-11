package chapter_11_exceptions_localization.exception;

/**
 * An unchecked exception is any exception that does not need to be declared or
 * handled by the application code where it is thrown. In Java, unchecked exceptions
 * include any class that inherits Runtime Exception or Error.2.
 * Unchecked Exceptions (Exceções Não Verificadas)
 * Definição:
 * São exceções que não são verificadas pelo compilador. Elas herdam de RuntimeException ou de suas subclasses.
 * O tratamento dessas exceções é opcional.
 * <p>
 * Exemplos de Unchecked Exceptions:
 * - NullPointerException
 * - ArrayIndexOutOfBoundsException
 * - ArithmeticException
 * <p>
 * Características:
 * - Representam erros de lógica do programador ou situações inesperadas.
 * - São frequentemente causadas por problemas que podem ser evitados com boa prática de programação.
 * - Não precisam ser declaradas ou tratadas explicitamente pelo compilador.
 */
public class UncheckedExceptions {
    public static void main(String[] args) {
        UncheckedExceptions ex = new UncheckedExceptions();
        try {
            ex.fall(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            ExampleArithmeticException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println();
        }

        try {
            ExampleClassCastException();
        } catch (ClassCastException e) {
            e.printStackTrace();
            System.out.println();
        }

        try {
            ExampleArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            ExampleNumberFormatException();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            ExampleNullPointerException();
        } catch (NullPointerException e) {
            /*
                java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "s" is null
                at UncheckedExceptions.ExampleNullPointerException(UncheckedExceptions.java:92)
                at UncheckedExceptions.main(UncheckedExceptions.java:58)
             */
            e.printStackTrace();
        }
    }

    void fall(Integer distance) {
        if (distance == null) {
            throw new IllegalArgumentException();
        }
    }

    // Commons Unchecked Exceptions
    static void ExampleArithmeticException() {
        int x = 11 / 0;
    }

    static void ExampleClassCastException() {
        Object d = 1.8;
        Integer i = (Integer) d;
    }

    static void ExampleArrayIndexOutOfBoundsException() {
        int array[] = new int[3];
        System.out.println(array[5]);

    }

    static void ExampleNumberFormatException() {
        Integer.parseInt("a");
    }

    static void ExampleNullPointerException() {
        String s = null;
        s.toUpperCase();
    }

}
