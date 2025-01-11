package chapter_11_exceptions_localization.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Only classes that implement the AutoCloseable interface can be used in a try-with-resources statement
 */
public class TryWithResources {

    // Take a look at the method that opens a file, reads the data, and close it
    public static void readFile() {
        FileInputStream is = null;
        try {
            is = new FileInputStream("myfile.txt");
            is.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }


    // The method above is long, because half the lines of code is closing the file
    // So, Java includes try-with-resource statement to automatically close all resources opened in a try clause.
    // Behind the scenes Java make all we made above.
    public static void readFile(String file) {
        try (FileInputStream is = new FileInputStream(file)) {
            is.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyFileClass implements AutoCloseable {
        private final int num;

        public MyFileClass(int num) {
            this.num = num;
        }

        @Override
        public void close() {
            System.out.println("Closing: " + num);
        }
    }

    // There is not a limit to add a resource. They just need to be separated by ;
    public static void main(String[] args) {
        try (var myFileClass = new MyFileClass(1); var myFileClass2 = new MyFileClass(2);
             var myFileClass3 = new MyFileClass(3); var myFileClass4 = new MyFileClass(4)) {
            throw new RuntimeException("Try Block Error!!!");
        } catch (Exception e) {
            System.out.println("Catch block");
            e.printStackTrace();
        } finally {
            System.out.println("Finally block");
        }

        /*
        Closing: 4
        Closing: 3
        Closing: 2
        Closing: 1
        Catch block
        Finally block
        java.lang.RuntimeException: Error!!! at TryWithResources.main(TryWithResources.java:57)
         */
    }
}
