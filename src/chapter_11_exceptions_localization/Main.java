package chapter_11_exceptions_localization;

public class Main {

    public static void test () throws InvalidException, RuntimeException {
        System.out.println("Something!");
        try {
            throw new RuntimeException("Some erro!");
        } catch (RuntimeException e) {
            System.out.println(e + "\n"); // Prints the error
            System.out.println(e.getMessage() + "\n"); // Prints the message
            e.printStackTrace(); // Type and message, and is the most helpful, because it shows the hierarchy (default).
        }

        // Applying a Multi-catch Block
        try {
            System.out.println();
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

        /*
        This code DON'T COMPILE because specifying related exceptions in the multi-catch is redundant.
        try {
            System.out.println();
        } catch (FileNotFoundException | IOException e) {
            e.printStackTrace();
        } */

        // finally Block
        /**
         * A finally Block WILL ALWAYS BE EXECUTED!
         */
        try {
            System.out.println("trying");
            throw new RuntimeException("trying");
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            System.out.println("finally");
        }

        System.out.println("FIM");
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (InvalidException e) {
            throw new RuntimeException(e);
        }
    }

    class Hopper {
        public void hop() {
            System.out.println("test...");
        }
    }

    /**
     * An overridden method may not declare any new or broader checked exceptions than the methods it inherits
     */
    class Bunny extends Hopper {
        //@Override
        //public void hop() throws Exception { it's not possible to throw a 'checked' exception

        //}
    }


}
