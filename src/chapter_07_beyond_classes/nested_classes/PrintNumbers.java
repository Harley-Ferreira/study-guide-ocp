package chapter_07_beyond_classes.nested_classes;

/**
 * Nested Classes
 * --------------
 * Local Class:
 * Is a nested class defined within a method.
 * Don't have an access modifier.
 * Can be declared final or abstract.
 * =======================================================================
 * Why can local classes only access final or Effectively final variables?
 * The compiler generates a separate '.class' file for each inner class. A separate class
 * has no way to refer to a local variable is finalor effectively final, Java can handle it
 * by passing a copy of the value or reference to the constructor of the local class.
 */
public class PrintNumbers {

    private int length = 5;
    public void calculate() {
        final int width = 20; // Required be final.
        class Calculator {
            public void multiply() {
                System.out.println(length * width);
            }
        }
        var calculator = new Calculator();
        calculator.multiply();
    }

    public static void main(String[] args) {
        PrintNumbers printer = new PrintNumbers();
        printer.calculate(); // 100
    }
}
